package com.example.finalproject.data.api;

import com.example.finalproject.data.model.category.CategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryService {
    @GET("api/categories")
    Call<CategoryResponse> getCategory();
}
