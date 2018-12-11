package com.example.krisandroid.noteme;

public class NoteContent_Model {
    private String TitleNote, Date;

    public NoteContent_Model (String TitleNote, String Date) {
        this.TitleNote = TitleNote;
        this.Date = Date;
    }

    public String getTitleNote() {
        return TitleNote;
    }

    public void setTitleNote(String Note) {
        this.TitleNote = Note;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

}
