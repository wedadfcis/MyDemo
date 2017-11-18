package com.example.wedad.mydemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wedad on 11/14/2017.
 */

public class Filems {
    @SerializedName("title")
    String title;
    @SerializedName("image")
    String image;
    @SerializedName("rating")
    double rating;
    @SerializedName("releaseYear")
    int releaseYear;
    @SerializedName("gener")
    String[] gener;

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String[] getGener() {
        return gener;
    }
}
