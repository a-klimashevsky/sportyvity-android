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

    @SerializedName("reps")
    private int mReps;

    @SerializedName("sets")
    private int mSets;

    @SerializedName("comments")
    private String mComments;

    public Workout getWorkout() {
        return mWorkout;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getReps() {
        return mReps;
    }

    public int getSets() {
        return mSets;
    }

    public String getComments() {
        return mComments;
    }
}
