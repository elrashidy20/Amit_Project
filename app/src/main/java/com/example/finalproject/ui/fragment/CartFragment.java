package com.example.finalproject.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.data.api.ApiManager;
import com.example.finalproject.data.model.cart.AddToCartResponse;
import com.example.finalproject.helper.TokenManager;
import com.example.finalproject.ui.adapter.CartAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CartFragment extends Fragment {


    public CartFragment() {
        // Required empty public constructor
    }


    RecyclerView cartRecycler;
    CartAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    NavController navController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }
    protected void intiRecycler(View v){

        cartRecycler=v.findViewById(R.id.cartRecycler);
        adapter=new CartAdapter(getContext());

        layoutManager=new LinearLayoutManager(getContext());
        cartRecycler.setLayoutManager(layoutManager);

        cartRecycler.setAdapter(adapter);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intiRecycler(view);

        TokenManager token =new TokenManager(getContext());
        String tokenid=token.getToken();
        ApiManager.getCartService().addToCartFun("Bearer "+tokenid).enqueue(
                new Callback<AddToCartResponse>() {
                    @Override
                    public void onResponse(Call<AddToCartResponse> call, Response<AddToCartResponse> response) {
                        if(response.isSuccessful())
                        {
                            adapter.setModelList(response.body().getProducts());
                        }
                        else
                        {
                            Toast.makeText(getContext(),""+response.code(),Toast.LENGTH_LONG).show();


                        }
                    }

                    @Override
                    public void onFailure(Call<AddToCartResponse> call, Throwable t) {

                    }
                }
        );
    }
}