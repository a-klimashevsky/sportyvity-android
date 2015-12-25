package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex Klimashevsky on 22.12.2015.
 */
public class Session {
    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
