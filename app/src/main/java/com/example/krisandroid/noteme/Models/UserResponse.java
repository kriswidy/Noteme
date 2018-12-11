package com.example.krisandroid.noteme.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kris on 09/12/18.
 */

public class UserResponse {
    @SerializedName("status") private String status;
    @SerializedName("result") private  User user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserResponse(String status, User user) {
        this.status = status;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
