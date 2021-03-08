package com.example.finalproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.data.api.ApiManager;
import com.example.finalproject.data.model.UserResponse;
import com.example.finalproject.helper.TokenManager;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends AppCompatActivity {
    EditText username, password;
    TextView goToregister;
    Button sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
        goToregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Login.this,SignUp.class);
                startActivity(intent);
                finish();

            }
        });
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signin();

            }
        });



    }
    protected void initialize()
    {
        username = findViewById(R.id.Username);
        password = findViewById(R.id.password);
        goToregister=findViewById(R.id.dont);
        sign_in=findViewById(R.id.button_SignIn);
    }
    protected void signin()
    {
        String name=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        TokenManager token =new TokenManager(getApplicationContext());
        Map<String,String> user=new HashMap();
        user.put("email",name);
        user.put("password",pass);




        ApiManager.getUserService().userLogin(user).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful())
                {
                    token.saveToken(response.body().getToken());
                    Intent intent=new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Log.d("dddddddddddd", "onResponse: "+response.code());


                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

                Log.d("ddddddddddddd", "onFailure: "+t.getLocalizedMessage());
            }
        });
    }
}