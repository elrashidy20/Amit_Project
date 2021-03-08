package com.example.finalproject.data.model;

import com.google.gson.annotations.SerializedName;

public class CartResponse{

	@SerializedName("message")
	private String message;

	public String getMessage(){
		return message;
	}
}