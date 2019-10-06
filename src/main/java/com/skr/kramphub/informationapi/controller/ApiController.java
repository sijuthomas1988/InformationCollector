package com.skr.kramphub.informationapi.controller;

import com.skr.kramphub.informationapi.exception.ServiceException;
import com.skr.kramphub.informationapi.model.ErrorDetails;
import com.skr.kramphub.informationapi.model.ItemResponse;
import com.skr.kramphub.informationapi.service.ItemService;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Controller class
 */
@RestController
@RequestMapping("/v1")
@Api(value = "Data Fetching System", description = "Operations pertaining to fetching data from external resources")
public class ApiController {

    Logger logger = LoggerFactory.getLogger(ApiController.class);

    /** Service implementation class used for operations from controller */
    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "Fetches a list of available objects based on the input",
            notes = "Returns the available Books and Albums based on preconfigured count", tags={  })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list", response = ItemResponse.class),
            @ApiResponse(code = 404, message = "Resource you are trying to reach is not found/available", response = ErrorDetails.class)})
    @RequestMapping(value = "/getInfo/{input}", produces = { "application/json" }, method = RequestMethod.GET)
    @Timed
    public ResponseEntity<List<ItemResponse>> findItems(@ApiParam(value = "input string to fetch objects",required=true )
                                           @PathVariable("input") Optional<String> input) throws ServiceException {
        if(input.isPresent()){
            List<ItemResponse> response = itemService.getItems(input.get());
            if(response.size() == 0) {
                String message = String.format("unable to find objects for the input provided");
                logger.error(message);
                throw new ServiceException(message);
            } else {
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } else {
            String message = String.format("Please provide a value");
            logger.error(message);
            throw new ServiceException(message);
        }

    }
}