package com.hpatel220037.sportlyapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class SessionDetailActivity extends AppCompatActivity {

    TextView sessionInfoText, availableSpotsText;
    ListView participantListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_detail);

        sessionInfoText = findViewById(R.id.sessionInfoText);
        availableSpotsText = findViewById(R.id.availableSpotsText);
        participantListView = findViewById(R.id.participantListView);

        String sport = "Volleyball";
        String gym = "Gym 2";
        String time = "6:00 PM - 7:30 PM";
        int maxSpots = 10;

        List<String> participants = Arrays.asList("Rohan", "Prem", "Harprit", "Bito", "Happy");
        int availableSpots = maxSpots - participants.size();

        sessionInfoText.setText("Sport: " + sport + "\nGym: " + gym + "\nTime: " + time);
        availableSpotsText.setText("Available Spots: " + availableSpots);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                participants
        );
        participantListView.setAdapter(adapter);

    }
}