package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Request extends RealmObject {

    @SerializedName("from")
    private Client from;

    @SerializedName("to")
    private Trainer trainer;

    @SerializedName("aim")
    private int aim;

    @SerializedName("status")
    private int status;

    @SerializedName("comments")
    private String comment;

    public Client getFrom() {
        return from;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public int getAim() {
        return aim;
    }

    public int getStatus() {
        return status;
    }

    public String getComment() {
        return comment;
    }

    public void setFrom(Client from) {
        this.from = from;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setAim(int aim) {
        this.aim = aim;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
