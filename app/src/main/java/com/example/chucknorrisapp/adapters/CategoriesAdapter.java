package com.example.chucknorrisapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chucknorrisapp.R;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {
    private List<String> categories;
    private ItemClickListener clickListener;
    private Context context;

    public CategoriesAdapter(Context context) {
        this.context = context;
        this.categories = new ArrayList<>();
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category_item, parent, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoriesViewHolder holder, final int position) {
        String categoryName = categories.get(position);
        holder.categoryName.setText(categoryName);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(categories.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public void setData(List<String> categories) {
        this.categories = categories;
        this.notifyDataSetChanged();
    }

    protected static class CategoriesViewHolder extends RecyclerView.ViewHolder {
        private final View view;
        private TextView categoryName;

        CategoriesViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            categoryName = view.findViewById(R.id.category_name);
        }
    }

    public interface ItemClickListener {
        void onItemClick(String category);
    }
}