package com.example.sidkathuria14.urlshort.api;

import com.example.sidkathuria14.urlshort.models.ShortenerModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by sidkathuria14 on 26/9/17.
 */

public interface UrlShortenerApi {
  //  @GET("urlshortener/v1/url")
//    @GET("/urlshortener/v1/url?shortUrl=http://goo.gl/fbsS")
//    Call<ShortenerModel> ShortenUrl(
//            //@Query("shortUrl")String shortUrl,@Query("key")String key
//     );
  @Headers("Content-Type: application/json")
    @POST("https://www.googleapis.com/urlshortener/v1/url")
    Call<ShortenerModel> ShortUrl(@Header("Content-Type: application/json")String Content_Type);
}
