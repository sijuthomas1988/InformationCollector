package com.skr.kramphub.informationapi.exception;

/**
 * Class used for throwing API exceptions
 */
public class ApiException extends Exception {

    /** status code */
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
    public ApiException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * Constructor
     *
     * @param code
     *     status code
     */
    public ApiException(int code) {
        super(String.valueOf(code));
        this.code = code;
    }

    /**
     * Constructor
     *
     * @param message
     *     error message
     */
    public ApiException(String message) {
        super(message);
        this.message = message;
    }
}