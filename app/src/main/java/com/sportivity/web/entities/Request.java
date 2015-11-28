package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Request {

    @SerializedName("from")
    private Client mFrom;

    @SerializedName("to")
    private Trainer mTrainer;

    @SerializedName("aim")
    private int mAim;

    @SerializedName("status")
    private int mStatus;

    @SerializedName("comments")
    private String mComment;

    public Client getFrom() {
        return mFrom;
    }

    public Trainer getTrainer() {
        return mTrainer;
    }

    public int getAim() {
        return mAim;
    }

    public int getStatus() {
        return mStatus;
    }

    public String getComment() {
        return mComment;
    }
}
