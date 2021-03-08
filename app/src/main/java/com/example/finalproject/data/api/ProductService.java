package com.example.finalproject.data.api;

import com.example.finalproject.data.model.CartResponse;
import com.example.finalproject.data.model.product.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductService {

    @GET("api/products")
    Call<ProductResponse> getProduct();

    @PUT("api/user/products/{id}")
    Call<CartResponse> addToCart(@Path("id") int id,
                                 @Header("Authorization")String token,
                                 @Query("amount") int amount
                                 );


}
