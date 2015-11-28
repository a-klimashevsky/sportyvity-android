package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Result {

    @SerializedName("exercise")
    private Exercise mExercise;

    @SerializedName("weight")
    private int mWeight;

    @SerializedName("unit")
    private int mUnit;

    @SerializedName("reps")
    private int mReps;

    @SerializedName("date")
    private Date mDate;

    public Exercise getExercise() {
        return mExercise;
    }

    public int getWeight() {
        return mWeight;
    }

    public int getReps() {
        return mReps;
    }

    public Date getDate() {
        return mDate;
    }
}
