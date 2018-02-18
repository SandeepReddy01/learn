package com.amar.org.getdata;

import com.google.gson.annotations.SerializedName;

/**
 * Created by govt on 21-10-2017.
 */

public class Menu {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("price")
    private String price;

    @SerializedName("description")
    private String desctiption;

    @SerializedName("thumbnail")
    private String thumbnail;

    public Menu(String id, String name, String price, String desctiption, String thumbnail){
        this.id = id;
        this.name = name;
        this.price = price;
        this.desctiption = desctiption;
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesctiption() {
        return desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
