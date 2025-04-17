package com.rrajasekarhenry.sportlyapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText usernameInput, passwordInput;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Views
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);

        // Set Login Button click listener
        loginButton.setOnClickListener(v -> {
            // Get username and password from the input fields
            String username = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            // Check credentials
            if (username.equals("admin") && password.equals("1234")) {
                // If credentials are correct, navigate to HomeActivity
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish(); // Close the current activity
            } else {
                // If credentials are incorrect, show an error message
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
