package com.p_gudishala.sportlyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class SessionAdapter extends ArrayAdapter<Session> {

    public SessionAdapter(Context context, List<Session> sessions) {
        super(context, 0, sessions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Session session = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_session, parent, false);
        }

        TextView sport = convertView.findViewById(R.id.sportText);
        TextView participants = convertView.findViewById(R.id.participantsText);
        TextView time = convertView.findViewById(R.id.timeFrameText);
        TextView gym = convertView.findViewById(R.id.gymNumberText);

        sport.setText("Sport: " + session.getSport());

        if (session.getParticipants() != null) {
            participants.setText("Participants: " + session.getParticipants().size());
        } else {
            participants.setText("Participants: 0");
        }

        // Format the start time from timestamp to readable time
        String formattedTime = formatStartTime(session.getStartTime());
        time.setText("Time: " + formattedTime);

        gym.setText("Gym: " + session.getGym());

        return convertView;
    }

    private String formatStartTime(long startTimeMillis) {
        // Converts UNIX timestamp to readable date-time format
        Date date = new Date(startTimeMillis);
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        return formatter.format(date);
    }
}
