package com.example.sidkathuria14.urlshort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sidkathuria14.urlshort.api.UrlShortenerApi;
import com.example.sidkathuria14.urlshort.models.ShortenerModel;
import com.example.sidkathuria14.urlshort.models.post_model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.sidkathuria14.urlshort.MainActivity.API_KEY;
import static com.example.sidkathuria14.urlshort.MainActivity.TAG;

public class ShortenActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shorten);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.googleapis.com/")
                .build();
        tv = (TextView)findViewById(R.id.tv);
       final UrlShortenerApi api = retrofit.create(UrlShortenerApi.class);


        ((Button)findViewById(R.id.btnLink)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ;

                api.ShortUrl(new post_model(((EditText)findViewById(R.id.etLink)).getText().toString()),API_KEY).enqueue(new Callback<ShortenerModel>() {
                    @Override
                    public void onResponse(Call<ShortenerModel> call, Response<ShortenerModel> response) {
                        Log.d(TAG, "onResponse: "  );
                        tv.setText(response.body().getId());

                    }

                    @Override
                    public void onFailure(Call<ShortenerModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: ");
                    }
                });

            }
        });




    }
}
