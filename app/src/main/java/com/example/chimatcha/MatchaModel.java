package com.example.chimatcha;

public class MatchaModel {

    String name;
    int image;

    public MatchaModel(
            String name,
            int image){

        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}