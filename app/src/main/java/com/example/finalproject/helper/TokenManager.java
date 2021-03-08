package com.example.finalproject.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Display;

public class TokenManager {




    private SharedPreferences sharedPreferences;

    public TokenManager(Context context) {
    sharedPreferences=context.getSharedPreferences("Token", Context.MODE_PRIVATE);
    }

    public void saveToken(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Token", token);

        editor.apply();
    }

    public String getToken() {
        return sharedPreferences.getString("Token",null);
    }

}
