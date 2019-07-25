package com.example.chucknorrisapp.services.repositories;

import com.example.chucknorrisapp.models.Joke;
import com.example.chucknorrisapp.services.DataListener;

public interface JokeRepository {

    void getJokeFromCategory(String category, DataListener<Joke> listener);
}
