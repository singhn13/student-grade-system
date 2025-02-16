package com.example.gradeapp;

public class Assignment {
    private int id;
    private String title;

    public Assignment() {}

    public Assignment(String title) {
        this.title = title;
    }
    
    public Assignment(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public String toString() {
        return "Assignment{id=" + id + ", title='" + title + "'}";
    }
}
