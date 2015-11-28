package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Exercise extends RealmObject {

    @SerializedName("workout")
    private Workout workout;

    @SerializedName("title")
    private String title;

    @SerializedName("reps")
    private int reps;

    @SerializedName("sets")
    private int sets;

    @SerializedName("comments")
    private String comments;

    public Workout getWorkout() {
        return workout;
    }

    public String getTitle() {
        return title;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    public String getComments() {
        return comments;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
