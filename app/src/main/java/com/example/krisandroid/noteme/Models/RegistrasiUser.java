package com.example.krisandroid.noteme.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kris on 09/12/18.
 */

public class RegistrasiUser {
    @SerializedName("status") String status;
    @SerializedName("result") User mUser;
    @SerializedName("message") String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getmUser() {
        return mUser;
    }

    public void setmUser(User mUser) {
        this.mUser = mUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
