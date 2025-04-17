package com.rrajasekarhenry.sportlyapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    TextView welcomeHomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        welcomeHomeText = new TextView(this);
        welcomeHomeText.setText("Welcome to Home Page");
        welcomeHomeText.setTextSize(24); // Set font size
        welcomeHomeText.setTextColor(getResources().getColor(android.R.color.black));
        welcomeHomeText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        
        LinearLayout layout = findViewById(R.id.home_layout);
        layout.addView(welcomeHomeText);
    }
}
