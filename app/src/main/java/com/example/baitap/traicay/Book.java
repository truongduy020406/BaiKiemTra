package com.example.baitap.traicay;

public class Book {
    private int  resourceid;
    private String title;

    public Book(int resourceid, String title) {
        this.resourceid = resourceid;
        this.title = title;
    }

    public int getResourceid() {
        return resourceid;
    }

    public void setResourceid(int resourceid) {
        this.resourceid = resourceid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
