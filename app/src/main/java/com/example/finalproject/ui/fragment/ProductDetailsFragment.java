package com.example.finalproject.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.finalproject.R;
import com.example.finalproject.data.api.ApiManager;
import com.example.finalproject.data.model.CartResponse;
import com.example.finalproject.data.model.cart.AddToCartResponse;
import com.example.finalproject.data.model.product.Product;
import com.example.finalproject.helper.TokenManager;
import com.example.finalproject.ui.adapter.CartAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProductDetailsFragment extends Fragment {


    private Product productItem;


    public ProductDetailsFragment() {
        // Required empty public constructor
    }

    RecyclerView cartRecycler;
    CartAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ImageView product_img;
    TextView product_name,product_desc,product_title,product_price;
    Button addToCartBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
                productItem = (Product) getArguments().getSerializable("Product");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        product_img=view.findViewById(R.id.imageDetails);
        product_name=view.findViewById(R.id.name_details);
        product_desc=view.findViewById(R.id.description_details);
        product_price=view.findViewById(R.id.price_Details);
        product_title=view.findViewById(R.id.title_details);
        addToCartBtn=view.findViewById(R.id.button_add_to_cart);

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TokenManager token=new TokenManager(getContext());
                String tokenid=token.getToken();
                ApiManager.getProductService().addToCart(productItem.getId(),"Bearer "+tokenid,1).enqueue(new Callback<CartResponse>() {
                    @Override
                    public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                        if(response.isSuccessful())
                        {
                            Toast.makeText(getContext(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<CartResponse> call, Throwable t) {

                    }
                });

            }
        });

        Glide.with(getContext()).load(productItem.getAvatar()).into(product_img);
        product_name.setText(productItem.getName());
        product_desc.setText(productItem.getDescription());
        product_price.setText(Double.toString( productItem.getPrice()));
        product_title.setText(productItem.getTitle());




    }

}