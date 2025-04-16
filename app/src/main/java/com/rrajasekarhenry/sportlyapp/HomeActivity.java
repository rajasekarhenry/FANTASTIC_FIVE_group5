package com.rrajasekarhenry.sportlyapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Simple placeholder
        TextView text = new TextView(this);
        text.setText("Welcome to Home Page!");
        text.setTextSize(20);
        setContentView(text);
    }
}
