package com.skr.kramphub.informationapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Model Class for Error Object to be returned during response
 */
@ApiModel(description = "Response model for error returned")
public class ErrorDetails {

    /** Time stamp at which error occurred */
    @ApiModelProperty(notes = "timestamp at which the error occured")
    private Date timeStamp;
    /** message to be given as response */
    @ApiModelProperty(notes = "error message")
    private String message;
    /** Details of the error message like status code, uri */
    @ApiModelProperty(notes = "Details of the error message like status code, uri")
    private String details;

    /**
     * Custom Constructor
     *
     * @param timeStamp
     *     time at which error occured
     * @param message
     *     error message
     * @param details
     *     details of the error like uri, status code
     */
    public ErrorDetails(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    /**
     * @return time stamp at which error occured
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of time stamp at which error occurred
     *
     * @param timeStamp
     *     value of time stamp
     */
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return value of error message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of error message
     *
     * @param message
     *     value of error message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return value of details of error message
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets the value of details of error message
     *
     * @param details
     *     value of details of error message
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ErrorDetails{" +
                "timeStamp=" + timeStamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}