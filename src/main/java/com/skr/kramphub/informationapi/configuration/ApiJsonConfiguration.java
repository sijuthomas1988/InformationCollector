package com.skr.kramphub.informationapi.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Class that defines configuration for Json configuration
 */
@Configuration
@ConfigurationProperties("jsonapiconf")
@EnableConfigurationProperties
public class ApiJsonConfiguration {

    /** root node of google api response */
    private String googleapiroot;
    /** root node of apple api response */
    private String appleapiroot;
    /** list of nodes from which data needs to be retrieved */
    private List<String> googleapipath;
    /** node values that needs to be retrieved for google api */
    private List<String> googleapiattributes;
    /** list of nodes from which data needs to be retrieved */
    private List<String> appleapipath;
    /** node values that needs to be retrieved for apple api */
    private List<String> appleapiattributes;

    /**
     * @return a list of path values for retrieving nodes for google api
     */
    public List<String> getGoogleapipath() {
        return googleapipath;
    }

    /**
     * Sets the value for path that retrieves nodes for google api
     *
     * @param googleapipath
     *     list of path values
     */
    public void setGoogleapipath(List<String> googleapipath) {
        this.googleapipath = googleapipath;
    }

    /**
     * @return list of nodes from where values needs to be retrieved for google api
     */
    public List<String> getGoogleapiattributes() {
        return googleapiattributes;
    }

    /**
     * Sets the value of nodes from where values needs to be retrieved for google api
     *
     * @param googleapiattributes
     *     list of nodes where values are to be retrieved
     */
    public void setGoogleapiattributes(List<String> googleapiattributes) {
        this.googleapiattributes = googleapiattributes;
    }

    /**
     * @return a list of path values for retrieving nodes for apple api
     */
    public List<String> getAppleapipath() {
        return appleapipath;
    }

    /**
     * Sets the value for path that retrieves nodes for apple api
     *
     * @param appleapipath
     *     list of path values
     */
    public void setAppleapipath(List<String> appleapipath) {
        this.appleapipath = appleapipath;
    }

    /**
     * @return list of nodes from where values needs to be retrieved for apple api
     */
    public List<String> getAppleapiattributes() {
        return appleapiattributes;
    }

    /**
     * Sets the value for path that retrieves nodes for apple api
     *
     * @param appleapiattributes
     */
    public void setAppleapiattributes(List<String> appleapiattributes) {
        this.appleapiattributes = appleapiattributes;
    }

    /**
     * @return the value of root node of google api
     */
    public String getGoogleapiroot() {
        return googleapiroot;
    }

    /**
     * Sets the the value of root node of google api
     *
     * @param googleapiroot
     *     the value of root node
     */
    public void setGoogleapiroot(String googleapiroot) {
        this.googleapiroot = googleapiroot;
    }

    /**
     * @return the value of root node of apple api
     */
    public String getAppleapiroot() {
        return appleapiroot;
    }

    /**
     * Sets the the value of root node of apple api
     *
     * @param appleapiroot
     *     the value of root node
     */
    public void setAppleapiroot(String appleapiroot) {
        this.appleapiroot = appleapiroot;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ApiJsonConfiguration{" +
                "googleapiroot='" + googleapiroot + '\'' +
                ", appleapiroot='" + appleapiroot + '\'' +
                ", googleapipath=" + googleapipath +
                ", googleapiattributes=" + googleapiattributes +
                ", appleapipath=" + appleapipath +
                ", appleapiattributes=" + appleapiattributes +
                '}';
    }
}
