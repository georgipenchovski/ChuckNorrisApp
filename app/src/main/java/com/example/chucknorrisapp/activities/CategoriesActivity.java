package com.example.chucknorrisapp.activities;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.chucknorrisapp.R;
import com.example.chucknorrisapp.adapters.CategoriesAdapter;
import com.example.chucknorrisapp.usecases.CategoriesUsecase;

import java.util.List;

public class CategoriesActivity extends BaseActivity implements CategoriesUsecase.ViewListener, CategoriesAdapter.ItemClickListener {

    private CategoriesUsecase categoriesUsecase;
    private RecyclerView recyclerView;
    private CategoriesAdapter categoriesAdapter;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_categories;
    }

    @Override
    protected void onViewCreated() {
        categoriesUsecase = new CategoriesUsecase();
        categoriesUsecase.setViewListener(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        categoriesUsecase.getCategories();
    }

    @Override
    public void onItemClick(String category) {
        Toast.makeText(this, "Category: " + category, Toast.LENGTH_LONG).show();
        startActivity(JokeActivity.getIntent(this, category));
    }

    @Override
    public void showCategories(List<String> categories) {
        categoriesAdapter = new CategoriesAdapter(this);
        categoriesAdapter.setClickListener(this);
        categoriesAdapter.setData(categories);
        recyclerView.setAdapter(categoriesAdapter);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}



