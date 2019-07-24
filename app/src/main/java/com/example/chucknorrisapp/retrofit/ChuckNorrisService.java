package com.example.chucknorrisapp.retrofit;

import com.example.chucknorrisapp.models.Joke;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ChuckNorrisService {

    @GET("categories")
    Call<List<String>> getCategories();
    @GET("random")
    Call<Joke> getJokeFromCategory(@Query("category") String category);
}
