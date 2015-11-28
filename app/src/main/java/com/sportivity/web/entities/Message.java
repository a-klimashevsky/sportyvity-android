package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Message {
    @SerializedName("from")
    private Person mFrom;

    @SerializedName("to")
    private Person mTo;

    @SerializedName("text")
    private String mText;

    @SerializedName("date")
    private Date mDate;

    @SerializedName("type")
    private int mType;

    public Person getFrom() {
        return mFrom;
    }

    public Person getTo() {
        return mTo;
    }

    public String getText() {
        return mText;
    }

    public Date getDate() {
        return mDate;
    }

    public int getType() {
        return mType;
    }
}
