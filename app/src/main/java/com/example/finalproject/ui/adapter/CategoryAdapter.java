package com.example.finalproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalproject.R;
import com.example.finalproject.data.model.category.CategoriesItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private List<CategoriesItem> Category_list=new ArrayList<>();


    public CategoryAdapter(Context context) {
        this.context = context;
    }
    private Context context;
    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.category,parent,false);
        return new CategoryHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {

        CategoriesItem Category=Category_list.get(position);
        if(Category!=null)
        {
            holder.Category_name.setText(Category.getName());
            Glide.with(context).load(Category.getAvatar()).into(holder.Category_img);

        }
    }

    @Override
    public int getItemCount() {
        return Category_list.size();
    }

    public void setCategory_list(List<CategoriesItem> category_list) {
        Category_list = category_list;
        notifyDataSetChanged();
    }

    class CategoryHolder extends RecyclerView.ViewHolder{

        ImageView Category_img;
        TextView Category_name;


        public CategoryHolder(@NonNull View itemView) {
            super(itemView);

            Category_img=itemView.findViewById(R.id.category_image);
            Category_name=itemView.findViewById(R.id.category_name);
        }
    }
}
