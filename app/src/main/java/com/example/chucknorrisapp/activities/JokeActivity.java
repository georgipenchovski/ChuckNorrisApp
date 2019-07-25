package com.example.chucknorrisapp.activities;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chucknorrisapp.R;
import com.example.chucknorrisapp.models.Joke;
import com.example.chucknorrisapp.usecases.JokeUsecase;
import com.squareup.picasso.Picasso;

public class JokeActivity extends BaseActivity implements JokeUsecase.ViewListener {

    private static final String CATEGORY_NAME_EXTRA = "category_name";
    private String categoryName;
    private JokeUsecase jokeUsecase;

    private ImageView imgToolbar;
    private TextView txtJoke;
    private Button btnNextJoke;
    private TextView txtCategoryToolbar;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_joke;
    }

    @Override
    protected void onViewCreated() {
        getExtras();
        setupToolbar();

        jokeUsecase = new JokeUsecase();
        jokeUsecase.setViewListener(this);
        jokeUsecase.getJokeFromCategory(categoryName);

        txtJoke = findViewById(R.id.txt_joke);
        btnNextJoke = findViewById(R.id.btn_next_joke);
        btnNextJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jokeUsecase.getJokeFromCategory(categoryName);
            }
        });
    }

    private void getExtras() {
        categoryName = getIntent().getStringExtra(CATEGORY_NAME_EXTRA);
    }

    public static Intent getIntent(Context context, String categoryName) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(CATEGORY_NAME_EXTRA, categoryName);
        return intent;
    }

    @Override
    public void showJoke(Joke joke) {
        String text = joke.getValue();
        txtJoke.setText(text);
        Picasso.get().load(joke.getIconUrl()).into(imgToolbar);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void setupToolbar() {
        imgToolbar = findViewById(R.id.img_item);
        txtCategoryToolbar = findViewById(R.id.txt_category);
        txtCategoryToolbar.setText(categoryName);
    }
}
