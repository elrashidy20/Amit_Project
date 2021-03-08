package com.example.finalproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalproject.R;
import com.example.finalproject.data.model.cart.ProductsItem;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter  extends RecyclerView.Adapter<CartAdapter.CartHolder>{

    private List<ProductsItem> modelList = new ArrayList<>();
    private Context context;

    public CartAdapter(Context context) {
        this.context = context;

    }

    public void setModelList(List<ProductsItem> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        ProductsItem modellist = modelList.get(position);
        if (modellist != null) {

            Glide.with(context).load(modellist.getProduct().getAvatar()).into(holder.Product_img);
            holder.product_name.setText(modellist.getProduct().getName());
            holder.product_title.setText(modellist.getProduct().getTitle());
            holder.product_price.setText(String.valueOf(modellist.getProduct().getPrice()) + " EGP");
            holder.product_amount.setText(Integer.toString(modellist.getAmount()));

        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class CartHolder extends RecyclerView.ViewHolder {

        ImageView Product_img;
        TextView product_title,product_name,product_price,product_amount;
        ImageButton add_cart;


        public CartHolder(@NonNull View itemView) {
            super(itemView);
            product_amount=itemView.findViewById(R.id.product_cart_amount);
            Product_img=itemView.findViewById(R.id.product_image_cart);
            product_title=itemView.findViewById(R.id.product_title_cart);
            product_name=itemView.findViewById(R.id.product_name_cart);
            product_price=itemView.findViewById(R.id.product_price_cart);
            add_cart=itemView.findViewById(R.id.increment_btn);
        }
    }
}
