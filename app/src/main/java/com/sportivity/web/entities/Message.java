package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Message extends RealmObject {
    @SerializedName("from")
    private Client from;

    @SerializedName("to")
    private Trainer to;

    @SerializedName("text")
    private String text;

    @SerializedName("date")
    private Date date;

    @SerializedName("type")
    private int type;

    public Client getFrom() {
        return from;
    }

    public Trainer getTo() {
        return to;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public int getType() {
        return type;
    }

    public void setFrom(Client from) {
        this.from = from;
    }

    public void setTo(Trainer to) {
        this.to = to;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(int type) {
        this.type = type;
    }
}
