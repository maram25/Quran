package com.example.quran.Models;

public class SurahModel {
    private int Id;
    private String Name_en;
    private String number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName_ar() {
        return Name_ar;
    }

    public void setName_ar(String name_ar) {
        Name_ar = name_ar;
    }
}
