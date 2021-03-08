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
import com.example.finalproject.data.api.ProductListener;
import com.example.finalproject.data.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public  class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {


    private List<Product> product_Item_list =new ArrayList<>();

    private Context context;
    private ProductListener ClickListner;

    public ProductAdapter(Context context,ProductListener ClickListener) {
        this.context = context;
        this.ClickListner=ClickListener;
    }

    public void setProduct_Item_list(List<Product> product_Item_list) {
        this.product_Item_list = product_Item_list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override

    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.product,parent,false);
        return new ProductHolder(v);

    }



    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {

        Product p= product_Item_list.get(position);
        if (p!=null)
        {
            holder.product_name.setText(p.getName());
            holder.product_title.setText(p.getTitle());
            holder.product_price.setText(String.valueOf(p.getPrice())+" EGP");
            Glide.with(context).load(p.getAvatar()).into(holder.Product_img);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickListner.showProductDetails(p);
            }
        });
        holder.add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickListner.addToCart(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return product_Item_list.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder {

        ImageView Product_img;
        TextView product_title,product_name,product_price;
        ImageButton add_cart;


        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            Product_img=itemView.findViewById(R.id.product_image);
            product_title=itemView.findViewById(R.id.product_title);
            product_name=itemView.findViewById(R.id.product_name);
            product_price=itemView.findViewById(R.id.product_price);
            add_cart=itemView.findViewById(R.id.add_cart_btn);
        }
    }
}
