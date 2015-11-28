package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Client extends Person{

    @SerializedName("weight")
    private int mWeight;

    @SerializedName("units")
    private int mUnits;

    public int getWeight() {
        return mWeight;
    }

    public int getUnits() {
        return mUnits;
    }
}
