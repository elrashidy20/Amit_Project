package com.example.finalproject.data.model.product;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductResponse{

	@SerializedName("products")
	private List<Product> products;

	public List<Product> getProducts(){
		return products;
	}
}