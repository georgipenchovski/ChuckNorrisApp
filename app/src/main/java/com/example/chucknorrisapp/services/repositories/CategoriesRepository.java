package com.example.chucknorrisapp.services.repositories;

import com.example.chucknorrisapp.services.DataListener;

import java.util.List;

public interface CategoriesRepository {

     void getCategories(DataListener<List<String>> listener);
}
