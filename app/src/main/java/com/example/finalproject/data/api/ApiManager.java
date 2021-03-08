package com.example.finalproject.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static final String BASE_URL="http://retail.amit-learning.com/";
    private static Retrofit retrofit;



    private static Retrofit getInstance()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static UserService getUserService(){

        return getInstance().create(UserService.class);
    }
    public static ProductService getProductService(){
        return getInstance().create(ProductService.class);
    }

    public static CategoryService getCategoryService(){
        return getInstance().create(CategoryService.class);
    }
        public static AddToCart getCartService(){
        return getInstance().create(AddToCart.class);
    }


}
