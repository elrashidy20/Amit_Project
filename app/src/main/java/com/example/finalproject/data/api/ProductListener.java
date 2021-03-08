package com.example.finalproject.data.api;


import com.example.finalproject.data.model.product.Product;

public interface ProductListener {

    void showProductDetails(Product productItem);

    void addToCart(Product productItem);


}
