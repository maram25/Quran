package com.example.quran.data;

import com.example.quran.Models.ReadersNameModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("_arabic.php")
    Call<ReadersNameModel> getReders();

    @GET("_english.php")
    Call<ReadersNameModel> getRedersEn();
}
