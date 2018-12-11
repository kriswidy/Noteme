package com.example.krisandroid.noteme.Models;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kris on 09/12/18.
 */

public class User {
    @SerializedName("id_user") private Integer id_user;
    @SerializedName("email") private String email;
    @SerializedName("username") private String username;
    @SerializedName("password") private String password;

    public User(Integer id_user, String email, String username, String password){
        this.id_user = id_user;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
