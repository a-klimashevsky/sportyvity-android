package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Trainer extends Person{

    @SerializedName("description")
    private String mDescription;

    public String getDescription() {
        return mDescription;
    }
}
