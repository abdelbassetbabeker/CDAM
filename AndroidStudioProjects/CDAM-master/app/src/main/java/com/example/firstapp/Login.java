package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void onSignUpClick(View view) {
        // Create an Intent to navigate to the sign-in page (Assuming SignInActivity is your sign-in page)
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}