package com.example.multipleapicall.apiclient;

import android.content.Context;

import com.example.multipleapicall.interfaces.Apiinterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientMovie {
    public static final String BASE_URL_MOVIE = "https://api.themoviedb.org/";
    private final Retrofit retrofit ;
    private static ApiClientMovie mInstance;

    public ApiClientMovie(Context context) {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_MOVIE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public static synchronized ApiClientMovie getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ApiClientMovie(context);
        }
        return mInstance;
    }


    public Apiinterface getDetails() {
        return retrofit.create(Apiinterface.class);
    }
}
