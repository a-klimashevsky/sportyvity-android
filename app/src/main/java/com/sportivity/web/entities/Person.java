package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Person {

    @SerializedName("name")
    private String mName;

    @SerializedName("sex")
    private int mSex;

    @SerializedName("avatar")
    private String mAvatar;

    @SerializedName("birthday")
    private Date mBirthday;

    public String getName() {
        return mName;
    }

    public int getSex() {
        return mSex;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public Date getBirthday() {
        return mBirthday;
    }
}
