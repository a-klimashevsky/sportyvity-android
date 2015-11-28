package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Client extends RealmObject {

    @SerializedName("weight")
    private int weight;

    @SerializedName("units")
    private int units;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("sex")
    private int sex;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("birthday")
    private Date birthday;

    public Client() {
    }

    public int getWeight() {
        return weight;
    }

    public int getUnits() {
        return units;
    }

    public String getName() {
        return name;
    }

    public int getSex() {
        return sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getId() {
        return id;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
