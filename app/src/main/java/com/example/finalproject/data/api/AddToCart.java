package com.example.finalproject.data.api;

import com.example.finalproject.data.model.cart.AddToCartResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface AddToCart {
    @GET("api/user/products")
    Call<AddToCartResponse> addToCartFun( @Header("authorization") String token);
}
