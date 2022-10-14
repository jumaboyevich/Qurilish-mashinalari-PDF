package com.example.qurilishmashinalari.notes;

import java.util.List;

public class ListNote {

    private String title;
    private List<ThemeNote> themeNoteList;

    public ListNote(String title, List<ThemeNote> themeNoteList) {
        this.title = title;
        this.themeNoteList = themeNoteList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ThemeNote> getThemeNoteList() {
        return themeNoteList;
    }

    public void setThemeNoteList(List<ThemeNote> themeNoteList) {
        this.themeNoteList = themeNoteList;
    }
}
