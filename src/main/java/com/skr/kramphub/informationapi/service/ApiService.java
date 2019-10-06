package com.skr.kramphub.informationapi.service;

import com.skr.kramphub.informationapi.exception.ApiException;
import com.skr.kramphub.informationapi.model.Album;
import com.skr.kramphub.informationapi.model.Book;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Service Class that helps to call different API
 */
public interface ApiService {

    /**
     * Fetches information about available {@link Book} in the provided API
     *
     * @param input
     *     input value that is used to fetch data
     * @return list of {@link Book} objects
     * @throws ApiException
     *     thrown when an error occurs during API call
     */
    CompletableFuture<List<Book>> getBooks(String input) throws ApiException;

    /**
     * Fetches information about available {@link Album} in the provided API
     *
     * @param input
     *    input value that is used to fetch data
     * @return list of {@link Album} objects
     * @throws ApiException
     *     thrown when an error occurs during API call
     */
    CompletableFuture<List<Album>> getAlbums(String input) throws ApiException;

}
