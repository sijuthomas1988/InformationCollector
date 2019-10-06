package com.skr.kramphub.informationapi.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

/**
 * Class that defines configuration for api calls
 */
@Configuration
@ConfigurationProperties("apiconn")
@EnableConfigurationProperties
public class ApiConnectionConfiguration {

    private static final String GOOGLEAPI_DEFAULT_URL = "https://www.googleapis.com/books/v1/volumes";
    private static final String APPLEAPI_DEFAULT_URL = "http://itunes.apple.com/search";
    private static final String API_LIMIT = "5";

    /** Url to call google api*/
    private String googleApiUrl;
    /** Url to call apple api */
    private String appleApiUrl;
    /** Limit of results that can be fetched from google api */
    private String googleApilimit;
    /** Limit of results that can be fetched from api api */
    private String appleApilimit;

    /**
     * Post Construct method to set default values
     */
    @PostConstruct
    public void init() {
        if (googleApilimit == null || googleApilimit.isEmpty()) {
            this.googleApilimit = API_LIMIT;
        }
        if(appleApilimit == null || appleApilimit.isEmpty()) {
            this.appleApilimit = API_LIMIT;
        }
        if(googleApiUrl == null || googleApiUrl.isEmpty()) {
            this.googleApiUrl = GOOGLEAPI_DEFAULT_URL;
        }
        if(appleApiUrl == null || appleApiUrl.isEmpty()) {
            this.appleApiUrl = APPLEAPI_DEFAULT_URL;
        }
    }

    /**
     * @return google api url
     */
    public String getGoogleApiUrl() {
        return googleApiUrl;
    }

    /**
     * Sets the google api url
     *
     * @param googleApiUrl
     *     google api url
     */
    public void setGoogleApiUrl(String googleApiUrl) {
        this.googleApiUrl = googleApiUrl;
    }

    /**
     * @return apple api url
     */
    public String getAppleApiUrl() {
        return appleApiUrl;
    }

    /**
     * Sets the apple api url
     *
     * @param appleApiUrl
     *     apple api url
     */
    public void setAppleApiUrl(String appleApiUrl) {
        this.appleApiUrl = appleApiUrl;
    }

    /**
     * @return limit that defines the max results that can be fetched
     */
    public String getGoogleApilimit() {
        return googleApilimit;
    }

    /**
     * Sets the limit that defines the max results that can be fetched
     *
     * @param googleApilimit
     *     input that defines the max results that can be fetched
     */
    public void setGoogleApilimit(String googleApilimit) {
        this.googleApilimit = googleApilimit;
    }

    /**
     * @return limit that defines the max results that can be fetched
     */
    public String getAppleApilimit() {
        return appleApilimit;
    }

    /**
     * limit that defines the max results that can be fetched
     *
     * @param appleApilimit
     *     input that defines the max results that can be fetched
     */
    public void setAppleApilimit(String appleApilimit) {
        this.appleApilimit = appleApilimit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ApiConnectionConfiguration{" +
                "googleApiUrl='" + googleApiUrl + '\'' +
                ", appleApiUrl='" + appleApiUrl + '\'' +
                ", googleApilimit='" + googleApilimit + '\'' +
                ", appleApilimit='" + appleApilimit + '\'' +
                '}';
    }
}
