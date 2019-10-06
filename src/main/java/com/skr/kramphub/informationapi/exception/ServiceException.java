package com.skr.kramphub.informationapi.exception;

/**
 * Class that defines Service Exception
 */
public class ServiceException extends Exception{

    /** Status code */
    private int code;

    /** error message */
    private String message;

    /**
     * Constructor
     *
     * @param code
     *     status code
     * @param message
     *     error message
     */
    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * Constructor
     *
     * @param code
     *     status code
     */
    public ServiceException(int code) {
        this.code = code;
    }

    /**
     * Constructor
     *
     * @param message
     *     error message
     */
    public ServiceException(String message) {
        super(message);
        this.message = message;
    }
}