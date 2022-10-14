package com.example.qurilishmashinalari.notes;

import java.util.List;

public class ThemeNote {

    private String title;
    private int [] pages;

    public ThemeNote(String title, int[] pages) {
        this.title = title;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int[] getPages() {
        return pages;
    }

    public void setPages(int[] pages) {
        this.pages = pages;
    }
}
