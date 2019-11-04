package com.example.hw733testunitandmockito.testapipresenter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @Expose
    @SerializedName("login")
    public String login;

    @Expose
    @SerializedName("company")
    public String company;
}
