package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class WorkoutReport extends RealmObject {

    @SerializedName("workout")
    private Workout workout;

    @SerializedName("startTime")
    private Date startTime;

    @SerializedName("endTime")
    private Date endTime;

    public Workout getWorkout() {
        return workout;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
