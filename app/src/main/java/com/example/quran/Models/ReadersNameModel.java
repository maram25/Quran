package com.example.quran.Models;

public class ReadersNameModel {
    private int Id;
    private String Name_en;
    private String Image;
    private String Name_ar;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName_en() {
        return Name_en;
    }

    public void setName_en(String name_en) {
        Name_en = name_en;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName_ar() {
        return Name_ar;
    }

    public void setName_ar(String name_ar) {
        Name_ar = name_ar;
    }
}
