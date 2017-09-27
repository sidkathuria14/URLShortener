package com.example.sidkathuria14.urlshort.models;

/**
 * Created by sidkathuria14 on 26/9/17.
 */

public class ShortenerModel {
    String id,status;

    public ShortenerModel(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
