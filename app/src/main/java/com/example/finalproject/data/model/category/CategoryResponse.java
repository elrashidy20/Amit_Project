package com.example.finalproject.data.model.category;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CategoryResponse{

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	public List<CategoriesItem> getCategories(){
		return categories;
	}
}