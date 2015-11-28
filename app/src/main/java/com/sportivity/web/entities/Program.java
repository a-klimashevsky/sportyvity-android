package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Program {

    @SerializedName("author")
    private Trainer mAuthor;

    @SerializedName("client")
    private Client mClient;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("price")
    private int mPrice;

    @SerializedName("unit")
    private int mUnits;

    @SerializedName("comments")
    private String mComments;

    public Trainer getAuthor() {
        return mAuthor;
    }

    public Client getClient() {
        return mClient;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getPrice() {
        return mPrice;
    }

    public int getUnits() {
        return mUnits;
    }

    public String getComments() {
        return mComments;
    }
}
