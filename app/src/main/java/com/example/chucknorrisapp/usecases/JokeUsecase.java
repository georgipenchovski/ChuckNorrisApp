package com.example.chucknorrisapp.usecases;

import com.example.chucknorrisapp.models.Joke;
import com.example.chucknorrisapp.services.DataListener;
import com.example.chucknorrisapp.services.DataService;
import com.example.chucknorrisapp.services.repositories.JokeRepository;

public class JokeUsecase {

    private ViewListener viewListener;
    private JokeRepository jokeRepository;

    public JokeUsecase() {
        jokeRepository = new DataService();
    }

    public void getJokeFromCategory(String categoryName) {
        jokeRepository.getJokeFromCategory(categoryName, new DataListener<Joke>() {
            @Override
            public void onDataReceived(Joke joke) {
                viewListener.showJoke(joke);
            }

            @Override
            public void onDataError(String message) {
                viewListener.showErrorMessage(message);
            }
        });
    }

    public void setViewListener(JokeUsecase.ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    public interface ViewListener {

        void showJoke(Joke joke);

        void showErrorMessage(String message);
    }
}
