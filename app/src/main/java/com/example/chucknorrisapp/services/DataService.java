package com.example.chucknorrisapp.services;

import com.example.chucknorrisapp.models.Joke;
import com.example.chucknorrisapp.retrofit.ChuckNorrisService;
import com.example.chucknorrisapp.retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataService implements JokeRepository, CategoriesRepository {

    static ChuckNorrisService service;

    public DataService() {
        service = RetrofitInstance.getApi();
    }

    @Override
    public void getCategories(final DataListener<List<String>> listener) {
        service.getCategories().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                listener.onDataReceived(response.body());
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                listener.onDataError();
            }
        });
    }

    @Override
    public void getJokeFromCategory(String category, final DataListener<Joke> listener) {
        service.getJokeFromCategory(category).enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                listener.onDataReceived(response.body());
            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
                listener.onDataError();
            }
        });
    }
}