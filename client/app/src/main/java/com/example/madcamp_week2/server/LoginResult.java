package com.example.madcamp_week2.server;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResult {
    private String name;

    @SerializedName("email")
    private String email;

    private String[] favorites;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
