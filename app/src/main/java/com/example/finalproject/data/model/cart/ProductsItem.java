package com.example.finalproject.data.model.cart;

import com.example.finalproject.data.model.product.Product;
import com.google.gson.annotations.SerializedName;

public class ProductsItem{

	@SerializedName("amount")
	private int amount;

	@SerializedName("total")
	private int total;

	@SerializedName("product")
	private Product product;

	@SerializedName("total_text")
	private String totalText;

	public int getAmount(){
		return amount;
	}

	public int getTotal(){
		return total;
	}

	public Product getProduct(){
		return product;
	}

	public String getTotalText(){
		return totalText;
	}
}