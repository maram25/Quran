package com.example.quran.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class SurahModel {

   @SerializedName("data")
   public List<Data> data;
    public class Data {
        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("link")
        private String link;
        public String getId() {
            return id;
        }

        public void setId(String id) {
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
