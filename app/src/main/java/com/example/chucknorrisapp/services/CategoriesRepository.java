package com.example.chucknorrisapp.services;

import java.util.List;

public interface CategoriesRepository {

     void getCategories(DataListener<List<String>> categories);
}
