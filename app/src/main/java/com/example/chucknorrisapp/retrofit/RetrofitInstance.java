package com.example.chucknorrisapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static final String BASE_URL = "https://api.chucknorris.io/jokes/";
    private static RetrofitInstance retrofit;
    private static ChuckNorrisService service;

    private RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ChuckNorrisService.class);

    }

    public static RetrofitInstance getInstance() {
        if (retrofit == null) {
            return retrofit = new RetrofitInstance();
        } else {
            return retrofit;
        }
    }

    public static ChuckNorrisService getApi() {
        return getInstance().service;
    }

}
