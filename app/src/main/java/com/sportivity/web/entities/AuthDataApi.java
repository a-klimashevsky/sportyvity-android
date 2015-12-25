package com.sportivity.web.entities;

import com.sportivity.Constants;

/**
 * Created by Alex Klimashevsky on 22.12.2015.
 */
public class AuthDataApi {
    private String id;
    private Constants.UserType userType;
    private Constants.AuthType authType;
    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Constants.UserType getUserType() {
        return userType;
    }

    public void setUserType(Constants.UserType userType) {
        this.userType = userType;
    }

    public Constants.AuthType getAuthType() {
        return authType;
    }

    public void setAuthType(Constants.AuthType authType) {
        this.authType = authType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
