package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText passwordPrefixEditText;
    private EditText mobileEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);



        Spinner spinner = findViewById(R.id.CoCode);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.phoneCode, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        // Initialize UI elements
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        mobileEditText = findViewById(R.id.mobileEditText);
        loginButton = findViewById(R.id.signupButton);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input from EditText fields
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String selectedCoCode = spinner.getSelectedItem().toString(); // Get the selected value from the Spinner
                String mobile = mobileEditText.getText().toString();

                // Create a data object and serialize it (You need to create a custom data class)
                UserData userData = new UserData(firstName, lastName, email, password, selectedCoCode, mobile);

                // Start the result activity and pass the serialized data as an extra
                Intent intent = new Intent(SignUp.this, Home.class);
                intent.putExtra("userData", userData);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void onSignInClick(View view) {
        // Create an Intent to navigate to the sign-in page (Assuming SignInActivity is your sign-in page)
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}