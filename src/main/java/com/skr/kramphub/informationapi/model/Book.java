package com.skr.kramphub.informationapi.model;

import java.util.List;

/**
 * Model Class for Book Object
 */
public class Book {

    /** type of the object */
    private String printType;
    /** title of the object */
    private String title;
    /** list of authors of the object */
    private List<String> authors;

    /**
     * @return type of the object
     */
    public String getPrintType() {
        return printType;
    }

    /**
     * Sets the type of the object
     *
     * @param printType
     *     type of the object
     */
    public void setPrintType(String printType) {
        this.printType = printType;
    }

    /**
     * @return title of the object
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the  title of the object
     *
     * @param title
     *     title of the object
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return list of authors
     */
    public List<String> getAuthors() {
        return authors;
    }

    /**
     * Sets the list of authors
     *
     * @param authors
     *     list of authors
     */
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Book{" +
                "printType='" + printType + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                '}';
    }
}
