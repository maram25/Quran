package com.example.quran.data;

import com.example.quran.Models.ReadersNameModel;
import com.example.quran.Models.SurahModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIInterface {

//    @GET("_arabic.php")
//    Call<ReadersNameModel> getReders();
//
//    @GET("_english.php")
//    Call<ReadersNameModel> getRedersEn();

    @Headers({"Accept: application/json"})
    @GET("reciters")
    public Call<ReadersNameModel>get_Readers( @Query("locale") String Lang);


    @Headers({"Accept: application/json"})
    @GET("reciters/suras")
    public Call<SurahModel>get_Surah(@Query("reciter_id") int reciter_id,
                                       @Query("locale") String Lang);
}
