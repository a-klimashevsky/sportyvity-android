package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Trainer extends RealmObject {

    @SerializedName("priceRate")
    private String priceRate;

    public Trainer() {
    }

    public Trainer(String name, String avatar, String priceRate, float rating) {
        this.name = name;
        this.avatar = avatar;
        this.priceRate = priceRate;
        this.rating = rating;
    }

    @SerializedName("type")
    private int type;

    @SerializedName("rating")
    private float rating;

    @SerializedName("description")
    private String description;

    @SerializedName("id")
    @PrimaryKey
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("sex")
    private int sex;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("birthday")
    private Date birthday;

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public String getPriceRate() {
        return priceRate;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setPriceRate(String priceRate) {
        this.priceRate = priceRate;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
