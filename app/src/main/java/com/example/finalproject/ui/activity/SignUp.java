package com.example.finalproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

public class SignUp extends AppCompatActivity {

    EditText name_edit,email_edit,pass_edit;
    Button signup_btn;
    TextView goTologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initview();
        goTologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }
    private void initview() {
        pass_edit = findViewById(R.id.password_signUp);
        name_edit = findViewById(R.id.userName_signUp);
        email_edit = findViewById(R.id.email_signUp);
        goTologin=findViewById(R.id.have_acc);
        signup_btn=findViewById(R.id.signUp_btn);

    }
    private void signUp(){
        String name=name_edit.getText().toString().trim();
        String email=email_edit.getText().toString().trim();
        String pass=pass_edit.getText().toString().trim();
        TokenManager token=new TokenManager(getApplicationContext());

        if(name.isEmpty()||email.isEmpty()||pass.isEmpty())
        {
            Toast.makeText(this,"Check Your Data",Toast.LENGTH_SHORT);
        }
        else
        {
            Map<String,String> user=new HashMap();
            user.put("name",name);
            user.put("email",email);
            user.put("password",pass);
            ApiManager.getUserService().userRegister(user).enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    if (response.isSuccessful()) {
                        token.saveToken(response.body().getToken());
                        Intent intent=new Intent(SignUp.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }


                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {

                }
            });
        }

    }
}