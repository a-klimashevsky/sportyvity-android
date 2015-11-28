package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Workout extends RealmObject {

    @SerializedName("program")
    private Program program;

    @SerializedName("title")
    private String title;

    public Program getProgram() {
        return program;
    }

    public String getTitle() {
        return title;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
