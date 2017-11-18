package com.example.wedad.mydemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wedad on 11/14/2017.
 */

public class ApiClient {

    public static final String baseUrl = "https://api.androidhive.info/json/";
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }
}
