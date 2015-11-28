package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class WorkoutReport {

    @SerializedName("workout")
    private Workout mWorkout;

    @SerializedName("startTime")
    private Date mStartTime;

    @SerializedName("endTime")
    private Date mEndTime;

    public Workout getWorkout() {
        return mWorkout;
    }

    public Date getStartTime() {
        return mStartTime;
    }

    public Date getEndTime() {
        return mEndTime;
    }
}
