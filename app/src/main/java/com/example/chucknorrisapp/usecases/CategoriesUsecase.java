package com.example.chucknorrisapp.usecases;

import com.example.chucknorrisapp.services.repositories.CategoriesRepository;
import com.example.chucknorrisapp.services.DataListener;
import com.example.chucknorrisapp.services.DataService;

import java.util.List;

public class CategoriesUsecase {

    private ViewListener viewListener;
    private CategoriesRepository categoriesRepository;

    public CategoriesUsecase() {
        categoriesRepository = new DataService();
    }

    public void getCategories() {
        categoriesRepository.getCategories(new DataListener<List<String>>() {
            @Override
            public void onDataReceived(List<String> data) {
                viewListener.showCategories(data);
            }

            @Override
            public void onDataError(String message) {
                viewListener.showErrorMessage(message);
            }
        });
    }

    public void setViewListener(ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    public interface ViewListener {

        void showCategories(List<String> categories);

        void showErrorMessage(String message);
    }
}


