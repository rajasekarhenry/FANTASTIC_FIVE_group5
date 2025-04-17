package com.b_babu211290.sportlyapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class PlayActivity extends AppCompatActivity {

    TextView roundLabel, timerText, courtAssignments;
    Button startRoundBtn;
    int currentRound = 1;

    int playersPerCourt;
    int numCourts;
    int roundTime; // in seconds

    List<String> allPlayers;

    private CountDownTimer currentTimer;
    private boolean isTimerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        roundLabel = findViewById(R.id.roundLabel);
        timerText = findViewById(R.id.timerText);
        courtAssignments = findViewById(R.id.courtAssignments);
        startRoundBtn = findViewById(R.id.startRoundBtn);

        String selectedSport = "Basketball";

        GameRules rules = getGameRules(selectedSport);
        playersPerCourt = rules.playersPerCourt;
        numCourts = rules.courtCount;
        roundTime = rules.sessionMinutes * 60;

        int maxCapacity = playersPerCourt * numCourts;
        int overbookedCount = (int) Math.ceil(maxCapacity * 1.25);

        allPlayers = new ArrayList<>();
        for (int i = 1; i <= overbookedCount; i++) {
            allPlayers.add("Player " + i);
        }

        startRoundBtn.setOnClickListener(v -> startNewRound());
    }

    private void startNewRound() {
        if (isTimerRunning) return;

        roundLabel.setText("Round: " + currentRound);
        assignCourts();

        isTimerRunning = true;
        startRoundBtn.setEnabled(false);

        currentTimer = new CountDownTimer(roundTime * 1000L, 1000) {
            public void onTick(long millisUntilFinished) {
                timerText.setText("Time left: " + millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                timerText.setText("Round ended.");
                currentRound++;
                isTimerRunning = false;
                startRoundBtn.setEnabled(true);
            }
        }.start();
    }

    private void assignCourts() {
        List<String> shuffled = new ArrayList<>(allPlayers);
        Collections.shuffle(shuffled);

        StringBuilder builder = new StringBuilder();
        int totalPlayers = shuffled.size();
        int assigned = 0;

        for (int i = 1; i <= numCourts; i++) {
            builder.append("Court ").append(i).append(": ");
            for (int j = 0; j < playersPerCourt && assigned < totalPlayers; j++) {
                builder.append(shuffled.get(assigned)).append(j < playersPerCourt - 1 ? ", " : "");
                assigned++;
            }
            builder.append("\n");
        }

        if (assigned < totalPlayers) {
            builder.append("Sitting out: ");
            for (int i = assigned; i < totalPlayers; i++) {
                builder.append(shuffled.get(i)).append(i < totalPlayers - 1 ? ", " : "");
            }
        }

        courtAssignments.setText(builder.toString());
    }

    private GameRules getGameRules(String sport) {
        switch (sport.toLowerCase()) {
            case "basketball":
                return new GameRules(2, 5, 90);
            case "volleyball":
                return new GameRules(2, 6, 90);
            case "badminton":
                return new GameRules(3, 4, 120);
            case "dodgeball":
                return new GameRules(2, 6, 90);
            case "pickleball":
                return new GameRules(3, 4, 90);
            default:
                return new GameRules(2, 4, 90);
        }
    }

    private static class GameRules {
        int courtCount;
        int playersPerCourt;
        int sessionMinutes;

        GameRules(int courts, int players, int duration) {
            this.courtCount = courts;
            this.playersPerCourt = players;
            this.sessionMinutes = duration;
        }
    }
}