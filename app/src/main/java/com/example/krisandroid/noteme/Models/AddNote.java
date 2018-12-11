package com.example.krisandroid.noteme.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kris on 09/12/18.
 */

public class AddNote {
    @SerializedName("id_user") private Integer id_user;
    @SerializedName("judul") private  String judul;
    @SerializedName("note") private  String note;
    @SerializedName("tanggal") private String tanggal;

    public AddNote(Integer id_user, String judul, String note, String tanggal){
        this.id_user = id_user;
        this.judul = judul;
        this.note = note;
        this.tanggal = tanggal;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

}
