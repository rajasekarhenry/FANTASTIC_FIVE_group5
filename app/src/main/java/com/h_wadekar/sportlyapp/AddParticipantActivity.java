package com.h_wadekar.sportlyapp;


import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class AddParticipantActivity extends AppCompatActivity {

    EditText firstNameInput, lastNameInput, phoneInput, membershipInput, sessionIdInput;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participant);

        firstNameInput = findViewById(R.id.firstNameInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        phoneInput = findViewById(R.id.phoneInput);
        membershipInput = findViewById(R.id.membershipInput);
        sessionIdInput = findViewById(R.id.sessionIdInput);
        addBtn = findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = firstNameInput.getText().toString();
                String lname = lastNameInput.getText().toString();
                String phone = phoneInput.getText().toString();
                int memberNum = Integer.parseInt(membershipInput.getText().toString());
                long sessionId = Long.parseLong(sessionIdInput.getText().toString());

                Toast.makeText(AddParticipantActivity.this, "Added: " + fname + " to Session " + sessionId, Toast.LENGTH_LONG).show();

                firstNameInput.setText("");
                lastNameInput.setText("");
                phoneInput.setText("");
                membershipInput.setText("");
                sessionIdInput.setText("");
            }
        });
    }
}