package com.skr.kramphub.informationapi.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skr.kramphub.informationapi.utility.JsonUtil;
import com.skr.kramphub.informationapi.configuration.ApiConnectionConfiguration;
import com.skr.kramphub.informationapi.configuration.ApiJsonConfiguration;
import com.skr.kramphub.informationapi.exception.ApiException;
import com.skr.kramphub.informationapi.model.Album;
import com.skr.kramphub.informationapi.model.Book;
import com.skr.kramphub.informationapi.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Class to connect to Api Endpoints
 */
@Component
public class ApiServiceImpl implements ApiService {

    private final String MAXRESULTS_KEY_GOOGLE = "maxResults";
    private final String MAXRESULTS_KEY_APPLE = "limit";
    private final String GOOGLE_QUERY_PARAM = "q";
    private final String APPLE_QUERY_PARAM = "term";
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpEntity httpEntity = new HttpEntity("", new HttpHeaders());
    private final ObjectMapper objectMapper = new ObjectMapper();

    Logger logger = LoggerFactory.getLogger(ApiServiceImpl.class);

    @Autowired
    private ApiConnectionConfiguration apiConnectionConfiguration;

    @Autowired
    private ApiJsonConfiguration apiJsonConfiguration;

    /**
     * {@inheritDoc}
     */
    @Override
    @Async
    public CompletableFuture<List<Book>> getBooks(String input) throws ApiException {
        List<Book> bookList = new ArrayList<>();
        try {
            if(Integer.parseInt(apiConnectionConfiguration.getGoogleApilimit()) > 40) {
                String message = String.format("Max retrieval count exceeded. Please use values in range 0 to 40");
                logger.info(message);
                throw new ApiException(message);
            }
            URI googleUri = UriComponentsBuilder.fromUri(new URI(apiConnectionConfiguration.getGoogleApiUrl()))
                    .queryParam(GOOGLE_QUERY_PARAM, input).queryParam(MAXRESULTS_KEY_GOOGLE,
                            apiConnectionConfiguration.getGoogleApilimit()).build().toUri();
            ResponseEntity<String> responseEntityForBooks = restTemplate.exchange(googleUri, HttpMethod.GET, httpEntity, String.class);
            if(responseEntityForBooks.getStatusCodeValue() == 200) {
                List<Map<String, Object>> mapList = JsonUtil.fetchValuesFromJson(responseEntityForBooks.getBody(),
                        apiJsonConfiguration.getGoogleapiattributes(), apiJsonConfiguration.getGoogleapiroot(),
                        apiJsonConfiguration.getGoogleapipath());
                for(Map<String, Object> map : mapList) {
                    Book book = objectMapper.convertValue(map, Book.class);
                    bookList.add(book);
                }
                return CompletableFuture.completedFuture(bookList);
            } else {
                throw new ApiException(responseEntityForBooks.getStatusCodeValue(), responseEntityForBooks.getBody());
            }
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Async
    public CompletableFuture<List<Album>> getAlbums(String input) throws ApiException {
        List<Album> albumList = new ArrayList<>();
        try {
            URI appleUri = UriComponentsBuilder.fromUri(new URI(apiConnectionConfiguration.getAppleApiUrl()))
                    .queryParam(APPLE_QUERY_PARAM, input).queryParam(MAXRESULTS_KEY_APPLE, apiConnectionConfiguration.getAppleApilimit())
                    .build().toUri();
            ResponseEntity<String> responseEntityForAlbums = restTemplate.exchange(appleUri, HttpMethod.GET, httpEntity, String.class);
            if(responseEntityForAlbums.getStatusCodeValue() == 200) {
                List<Map<String, Object>> mapListForAlbums = JsonUtil.fetchValuesFromJson(responseEntityForAlbums.getBody(),
                        apiJsonConfiguration.getAppleapiattributes(), apiJsonConfiguration.getAppleapiroot(),
                        apiJsonConfiguration.getAppleapipath());
                for(Map<String, Object> map : mapListForAlbums) {
                    Album album = objectMapper.convertValue(map, Album.class);
                    albumList.add(album);
                }
                return CompletableFuture.completedFuture(albumList);
            } else {
                throw new ApiException(responseEntityForAlbums.getStatusCodeValue(), responseEntityForAlbums.getBody());
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ApiException(e.getMessage());
        }
    }

}