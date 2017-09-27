package com.example.sidkathuria14.urlshort;

import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sidkathuria14.urlshort.api.ExpandUrl;
import com.example.sidkathuria14.urlshort.api.UrlShortenerApi;
import com.example.sidkathuria14.urlshort.models.ShortenerModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {
EditText etLink;TextView tv;String link;
    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLink = (EditText)findViewById(R.id.etLink);
        etLink.getText().toString();
tv = (TextView)findViewById(R.id.tv);

        ((Button)findViewById(R.id.btnLink)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  link = etLink.getText().toString();
                link = "https://www.google.com";
//                shorten(link);
                Log.d(TAG, "onClick: " + link);
                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://www.googleapis.com")
                        .build();
                ExpandUrl myApi = retrofit.create(ExpandUrl.class);
                Log.d(TAG, "onClick: " +"checkpoint1");
                Callback<ShortenerModel> callback = new Callback<ShortenerModel>() {

                    @Override
                    public void onResponse(Call<ShortenerModel> call, Response<ShortenerModel> response) {
                        Log.d(TAG, "onResponse: " + "\n" + response.body().getStatus());
                        tv.setText(response.body().getId());
                    }

                    @Override
                    public void onFailure(Call<ShortenerModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: ");
                    }
                };
                myApi.Shorten(
                        link,"AIzaSyDzvQjgYqQ0zo_okaXowxIcIN_muCkARiA"
                        ).enqueue(callback);

            }
        });


    }

}
