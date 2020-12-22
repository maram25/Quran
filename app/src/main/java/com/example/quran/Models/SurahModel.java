package com.example.quran.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SurahModel {
//    private int Id;
//    private String Name_en;
//    private String number;
//    private String Name_ar;
//
//    public int getId() {
//        return Id;
//    }
//
//    public void setId(int id) {
//        Id = id;
//    }
//
//    public String getName_en() {
//        return Name_en;
//    }
//
//    public void setName_en(String name_en) {
//        Name_en = name_en;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public String getName_ar() {
//        return Name_ar;
//    }
//
//    public void setName_ar(String name_ar) {
//        Name_ar = name_ar;
//    }
@SerializedName("data")
public List<Data> data;
    public class Data {
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("link")
        private String link;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
