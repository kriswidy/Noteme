package com.example.krisandroid.noteme.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kris on 11/12/18.
 */

public class ResponseDelete {
    @SerializedName("status") String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
