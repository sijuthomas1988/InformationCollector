package com.skr.kramphub.informationapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Model Class that is used to return response
 */
@ApiModel(description = "Response Model for results returned")
public class ItemResponse {

    /** type of the object */
    @ApiModelProperty(notes = "Kind of Object returned")
    private String kind;
    /** title of the object */
    @ApiModelProperty(notes = "Title of the object returned")
    private String title;
    /** authors/artists of the object */
    @ApiModelProperty(notes = "name of author/artist of the object returned")
    private List<String> createdBy;

    /**
     * Default Constructor
     *
     * @param kind
     *     type of the object
     * @param title
     *     title of the object
     * @param createdBy
     *     authors/artists of the object
     */
    public ItemResponse(String kind, String title, List<String> createdBy) {
        this.kind = kind;
        this.title = title;
        this.createdBy = createdBy;
    }

    /**
     * @return gets the type returned
     */
    public String getKind() {
        return kind;
    }

    /**
     * Sets the type returned
     *
     * @param kind
     *     the value of type returned
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return value of the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title returned
     *
     * @param title
     *     value of the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return a list of authors or artists returned
     */
    public List<String> getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the list of authors or artists of the object returned
     *
     * @param createdBy
     *     list of authors or artists
     */
    public void setCreatedBy(List<String> createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ItemResponse{" +
                "kind='" + kind + '\'' +
                ", title='" + title + '\'' +
                ", createdBy=" + createdBy +
                '}';
    }
}
