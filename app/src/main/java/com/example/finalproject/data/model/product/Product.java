package com.example.finalproject.data.model.product;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable {

	@SerializedName("price_final_text")
	private String priceFinalText;

	@SerializedName("price_final")
	private double priceFinal;

	@SerializedName("description")
	private String description;

	@SerializedName("discount")
	private int discount;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("title")
	private String title;

	@SerializedName("discount_type")
	private Object discountType;

	@SerializedName("in_stock")
	private int inStock;

	@SerializedName("category_id")
	private int categoryId;

	@SerializedName("price")
	private int price;

	@SerializedName("name")
	private String name;

	@SerializedName("currency")
	private String currency;

	@SerializedName("id")
	private int id;

	public String getPriceFinalText(){
		return priceFinalText;
	}

	public double getPriceFinal(){
		return priceFinal;
	}

	public String getDescription(){
		return description;
	}

	public int getDiscount(){
		return discount;
	}

	public String getAvatar(){
		return avatar;
	}

	public String getTitle(){
		return title;
	}

	public Object getDiscountType(){
		return discountType;
	}

	public int getInStock(){
		return inStock;
	}

	public int getCategoryId(){
		return categoryId;
	}

	public int getPrice(){
		return price;
	}

	public String getName(){
		return name;
	}

	public String getCurrency(){
		return currency;
	}

	public int getId(){
		return id;
	}
}