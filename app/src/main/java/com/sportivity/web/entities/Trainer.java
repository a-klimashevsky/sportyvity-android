package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Trainer extends Person{

    private String mPriceRate;

    public Trainer(){}

    public Trainer(String name, String avatar, String priceRate, float rating){
        super(name, avatar);
        mPriceRate = priceRate;
        mRating = rating;
    }

    @SerializedName("type")
    private int mType;

    @SerializedName("rating")
    private float mRating;

    @SerializedName("description")
    private String mDescription;

    public String getDescription() {
        return mDescription;
    }

    public int getType() {
        return mType;
    }

    public float getRating() {
        return mRating;
    }

    public String getPriceRate() {
        return mPriceRate;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
