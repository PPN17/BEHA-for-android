package com.example.android.logindemo.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.android.logindemo.R;

public class Adminpg extends Activity {

    private EditText phoneNumberEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpg);

        // Initialize views
        phoneNumberEditText = findViewById(R.id.adminnumberEditText);
        passwordEditText = findViewById(R.id.adminPasword);
        loginButton = findViewById(R.id.adminloginbtn);

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Check if the entered phone number and password match the admin credentials
                if (phoneNumber.equals("12") && password.equals("Admin")) {
                    // Start the admpg activity
                    Intent intent = new Intent(Adminpg.this, Adminhomepg.class);
                    startActivity(intent);
                    finish(); // Optionally finish the current activity
                } else {
                    Toast.makeText(Adminpg.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
