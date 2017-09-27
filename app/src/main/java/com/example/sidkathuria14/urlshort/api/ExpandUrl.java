package com.example.sidkathuria14.urlshort.api;

import com.example.sidkathuria14.urlshort.models.ShortenerModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sidkathuria14 on 27/9/17.
 */

public interface ExpandUrl {
    @GET("/urlshortener/v1/url")
    // https://www.googleapis.com  /urlshortener/v1/url?shortUrl=http://goo.gl/fbsS
    Call<ShortenerModel> Shorten(@Query("shortUrl")String shorturl,@Query("key")String key);
}
