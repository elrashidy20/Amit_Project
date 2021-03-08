package com.example.finalproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.finalproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNavWithBottonNav();
    }




    protected void setupNavWithBottonNav()
    {
        bottomNavigationView=findViewById(R.id.my_bottom_nav);
        navController= Navigation.findNavController(this,R.id.my_nav_host);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

    }
}