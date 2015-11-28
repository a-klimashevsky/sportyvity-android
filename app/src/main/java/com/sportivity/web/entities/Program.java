package com.sportivity.web.entities;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Program extends RealmObject {

    @SerializedName("author")
    private Trainer author;

    @SerializedName("client")
    private Client client;

    @SerializedName("title")
    private String title;

    @SerializedName("price")
    private int price;

    @SerializedName("currency")
    private int currency;

    @SerializedName("comments")
    private String comments;

    public Trainer getAuthor() {
        return author;
    }

    public Client getClient() {
        return client;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getCurrency() {
        return currency;
    }

    public String getComments() {
        return comments;
    }

    public void setAuthor(Trainer author) {
        this.author = author;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
