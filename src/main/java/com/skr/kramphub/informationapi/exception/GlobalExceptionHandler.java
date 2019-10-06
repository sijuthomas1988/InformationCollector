package com.skr.kramphub.informationapi.exception;

import com.skr.kramphub.informationapi.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * Class to handle exceptions gracefully and construct error model
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handler used when {@link ServiceException} is  thrown
     *
     * @param e
     *     service exception
     * @param webRequest
     *     web request interceptor to fetch metadata of request
     * @return {@link ResponseEntity} of type {@link ErrorDetails}
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<?> serviceExceptionHandler(ServiceException e, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * Handler used when {@link Exception} is  thrown
     *
     * @param e
     *     exception
     * @param webRequest
     *     web request interceptor to fetch metadata of request
     * @return {@link ResponseEntity} of type {@link ErrorDetails}
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception e, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}