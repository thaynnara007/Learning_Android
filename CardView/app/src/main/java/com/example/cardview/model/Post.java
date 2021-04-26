package com.example.cardview.model;

public class Post {

    private String name;
    private String text;
    private int image;

    public Post(String name, String text, int image) {
        this.name = name;
        this.text = text;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
