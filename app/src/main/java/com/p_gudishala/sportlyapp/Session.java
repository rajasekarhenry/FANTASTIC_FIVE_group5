package com.p_gudishala.sportlyapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Session extends RealmObject {

    @PrimaryKey
    @SerializedName("session_id")
    private long sessionId;

    @SerializedName("sport")
    private String sport;

    @SerializedName("gym")
    private String gym;

    @SerializedName("start_time")
    private long startTime;

    @SerializedName("participants")
    private RealmList<Participant> participants;

    // Required no-arg constructor for Realm
    public Session() {}

    public Session(long sessionId, String sport, String gym, long startTime, RealmList<Participant> participants) {
        this.sessionId = sessionId;
        this.sport = sport;
        this.gym = gym;
        this.startTime = startTime;
        this.participants = participants;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public RealmList<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(RealmList<Participant> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", sport='" + sport + '\'' +
                ", gym='" + gym + '\'' +
                ", startTime=" + startTime +
                ", participants=" + participants +
                '}';
    }
}
