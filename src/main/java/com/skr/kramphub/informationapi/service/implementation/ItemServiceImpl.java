package com.skr.kramphub.informationapi.service.implementation;

import com.skr.kramphub.informationapi.exception.ApiException;
import com.skr.kramphub.informationapi.exception.ServiceException;
import com.skr.kramphub.informationapi.model.Album;
import com.skr.kramphub.informationapi.model.Book;
import com.skr.kramphub.informationapi.model.ItemResponse;
import com.skr.kramphub.informationapi.service.ApiService;
import com.skr.kramphub.informationapi.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Service Class
 */
@Service
public class ItemServiceImpl implements ItemService {

    Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    /** Api Service instance variable */
    @Autowired
    private ApiService apiService;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ItemResponse> getItems(String input) throws ServiceException {
        List<ItemResponse> itemResponses  = new ArrayList<>();
        try {
            CompletableFuture<List<Book>> responseEntityForBooks = apiService.getBooks(input);
            CompletableFuture<List<Album>> responseEntityForAlbums = apiService.getAlbums(input);
            CompletableFuture.allOf(responseEntityForBooks, responseEntityForAlbums).join();
            if(!responseEntityForBooks.get().isEmpty()) {
                responseEntityForBooks.get().stream().map(book -> new ItemResponse(book.getPrintType(), book.getTitle(),
                        book.getAuthors())).forEach(itemResponses::add);
            }
            if(!responseEntityForAlbums.get().isEmpty()) {
                responseEntityForAlbums.get().stream().map(album -> new ItemResponse(album.getKind(), album.getTrackName(),
                        Arrays.asList(album.getArtistName().split("&")))).forEach(itemResponses::add);
            }
            if(itemResponses.size() > 0) {
                Collections.sort(itemResponses, Comparator.comparing(ItemResponse::getTitle));
            }
            return itemResponses;
        } catch (ApiException e) {
            String message = String.format("Error thrown while fetching data");
            logger.error(message);
            throw new ServiceException(e.getMessage());
        } catch (InterruptedException e) {
            String message = String.format("Error thrown while streaming data from list of objects returned");
            logger.error(message);
            throw new ServiceException(message);
        } catch (ExecutionException e) {
            String message = String.format("Error thrown while streaming data from list of objects returned");
            logger.error(message);
            throw new ServiceException(message);
        }
    }
}