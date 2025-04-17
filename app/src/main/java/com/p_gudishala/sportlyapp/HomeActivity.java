package com.p_gudishala.sportlyapp;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import io.realm.RealmList;

public class HomeActivity extends AppCompatActivity {

    ListView sessionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sessionList = findViewById(R.id.sessionList);

        List<Session> sessions = new ArrayList<>();

        // Create RealmList for basketball participants
        RealmList<Participant> basketballParticipants = new RealmList<>();
        basketballParticipants.addAll(Arrays.asList(new Participant(), new Participant(), new Participant()));

        Session basketball = new Session(
                123456,
                "Basketball",
                "Gym 1",
                System.currentTimeMillis(),
                basketballParticipants
        );

        // Create RealmList for dodgeball participants
        RealmList<Participant> dodgeballParticipants = new RealmList<>();
        dodgeballParticipants.addAll(Arrays.asList(new Participant(), new Participant()));

        Session dodgeball = new Session(
                654321,
                "Dodgeball",
                "Gym 3",
                System.currentTimeMillis(),
                dodgeballParticipants
        );

        sessions.add(basketball);
        sessions.add(dodgeball);

        SessionAdapter adapter = new SessionAdapter(this, sessions);
        sessionList.setAdapter(adapter);
    }
}
