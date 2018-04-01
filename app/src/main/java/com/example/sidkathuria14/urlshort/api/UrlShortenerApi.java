package com.example.sidkathuria14.urlshort.api;

import com.example.sidkathuria14.urlshort.models.ShortenerModel;
import com.example.sidkathuria14.urlshort.models.post_model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by sidkathuria14 on 26/9/17.
 */

public interface UrlShortenerApi {

  @Headers("Content-Type: application/json")
    @POST("urlshortener/v1/url")
    Call<ShortenerModel> ShortUrl(@Body post_model postModel, @Query("key")String Content_Type);

}
