package com.example.krisandroid.noteme.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kris on 09/12/18.
 */

public class NoteResponse {
    @SerializedName("result")
    List<Note> listNote;

    public List<Note> getListNote() {
        return listNote;
    }

    public void setListNote(List<Note> listNote) {
        this.listNote = listNote;
    }
}
