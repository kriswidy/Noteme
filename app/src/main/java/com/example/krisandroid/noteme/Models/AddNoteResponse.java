package com.example.krisandroid.noteme.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kris on 09/12/18.
 */

public class AddNoteResponse {
    @SerializedName("result")
    List<AddNote> listNote;

    public List<AddNote> getListNote() {
        return listNote;
    }

    public void setListNote(List<AddNote> listNote) {
        this.listNote = listNote;
    }
}
