package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Workout {

    @SerializedName("program")
    private Program mProgram;

    @SerializedName("title")
    private String mTitle;

    public Program getProgram() {
        return mProgram;
    }

    public String getTitle() {
        return mTitle;
    }
}
