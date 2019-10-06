package com.skr.kramphub.informationapi.service;

import com.skr.kramphub.informationapi.exception.ServiceException;
import com.skr.kramphub.informationapi.model.ItemResponse;

import java.util.List;

/**
 * Service class that helps to fetch the objects from different API
 */
public interface ItemService {

    /**
     * Getter method to fetch values from different API based on the input provided
     *
     * @param input
     *     input value that needs to be passed to the api
     * @return returns an model object that holds all the data extracted from different API
     * @throws ServiceException
     *     throws if an exception occurs during execution
     */
    List<ItemResponse> getItems(String input) throws ServiceException;
}