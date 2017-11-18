package com.example.wedad.mydemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wedad on 11/14/2017.
 */

public interface ApiInterface {

    @GET("movies.json")
    Call<List<Filems>>getFilems();
}
