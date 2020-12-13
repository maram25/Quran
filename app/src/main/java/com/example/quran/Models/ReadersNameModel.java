package com.example.quran.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReadersNameModel {

    @SerializedName("reciters")
    public List<Data> data;

    public class Data{
        @SerializedName("count")
        private String Count;
        @SerializedName("id")
        private String Id;
        @SerializedName("letter")
        private String Letter;
        @SerializedName("name")
        private String Name;
        @SerializedName("rewaya")
        private String Rewaya;
        @SerializedName("Server")
        private String Server;

        public String getCount() {
            return Count;
        }

        public String getId() {
            return Id;
        }

        public String getLetter() {
            return Letter;
        }

        public String getName() {
            return Name;
        }

        public String getRewaya() {
            return Rewaya;
        }

        public String getServer() {
            return Server;
        }

        public String getSuras() {
            return Suras;
        }

        @SerializedName("suras")
        private String Suras;

    }
}
