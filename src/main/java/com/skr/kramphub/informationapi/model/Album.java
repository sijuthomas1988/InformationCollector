package com.skr.kramphub.informationapi.model;

/**
 * Model Class for Albums
 */
public class Album {

    /** type of the object */
    private String kind;
    /** track name of the object */
    private String trackName;
    /** authors/artists name of the object */
    private String artistName;

    /**
     * @return type of the object
     */
    public String getKind() {
        return kind;
    }

    /**
     * Sets the type of the object
     *
     * @param kind
     *     type of the object
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return track name of the object
     */
    public String getTrackName() {
        return trackName;
    }

    /**
     * Sets track name of the object
     *
     * @param trackName
     *     track name of the object
     */
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    /**
     * @return artists name of the object
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Sets the artists name of the object
     *
     * @param artistName
     *     artists name
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Album{" +
                "kind='" + kind + '\'' +
                ", trackName='" + trackName + '\'' +
                ", artistName=" + artistName +
                '}';
    }
}