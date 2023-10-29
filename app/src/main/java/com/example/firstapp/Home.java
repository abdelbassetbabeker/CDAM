package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // Retrieve the serialized data from the intent
        Intent intent = getIntent();
        UserData userData = (UserData) intent.getSerializableExtra("userData");

        // Display the user data in the result TextView
        TextView firstnameV = findViewById(R.id.firstnameV); firstnameV.setText(userData.getFirstName());
        TextView lastnameV = findViewById(R.id.lastnameV); lastnameV.setText(userData.getLastName());
        TextView emailV = findViewById(R.id.emailV); emailV.setText(userData.getEmail());
        TextView mobileV = findViewById(R.id.mobileV); mobileV.setText(userData.getMobile());


    }
}