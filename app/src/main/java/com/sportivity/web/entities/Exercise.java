package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Exercise {

    @SerializedName("workout")
    private Workout mWorkout;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("repeatTime")
    private int mRepeatTime;

    @SerializedName("try")
    private int mTry;

    @SerializedName("comments")
    private String mComments;

    public Workout getWorkout() {
        return mWorkout;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getRepeatTime() {
        return mRepeatTime;
    }

    public int getTry() {
        return mTry;
    }

    public String getComments() {
        return mComments;
    }
}
