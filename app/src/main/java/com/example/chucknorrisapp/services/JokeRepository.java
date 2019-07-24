package com.example.chucknorrisapp.services;

import com.example.chucknorrisapp.models.Joke;

public interface JokeRepository {

    void getJokeFromCategory(String category, DataListener<Joke> listener);
}
