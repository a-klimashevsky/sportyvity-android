package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Result extends RealmObject {

    @SerializedName("exercise")
    private Exercise exercise;

    @SerializedName("weight")
    private int weight;

    @SerializedName("unit")
    private int unit;

    @SerializedName("reps")
    private int reps;

    @SerializedName("date")
    private Date date;

    public Result() {
    }

    public Exercise getExercise() {
        return exercise;
    }

    public int getWeight() {
        return weight;
    }

    public int getReps() {
        return reps;
    }

    public Date getDate() {
        return date;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
