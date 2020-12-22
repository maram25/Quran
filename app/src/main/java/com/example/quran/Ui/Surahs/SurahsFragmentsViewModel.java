package com.example.quran.Ui.Surahs;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quran.Models.ReadersNameModel;
import com.example.quran.Models.SurahModel;
import com.example.quran.Utils.Utils;
import com.example.quran.data.APIClient;
import com.example.quran.data.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurahsFragmentsViewModel extends ViewModel {
    MutableLiveData<List<SurahModel.Data>> NamesSurahr=new MutableLiveData<>();
    MutableLiveData<Boolean> NoInternet=new MutableLiveData<>();

    APIInterface apiInterface;

    public void GetSurahName() {
        apiInterface  = APIClient.getClient().create(APIInterface.class);
        Call<SurahModel> call=apiInterface.get_Surah(Utils.IdReader,Utils.Lang);
        call.enqueue(new Callback<SurahModel>() {
            @Override
            public void onResponse(Call<SurahModel> call, Response<SurahModel> response) {
                NamesSurahr.setValue(response.body().data);

            }
            @Override
            public void onFailure(Call<SurahModel> call, Throwable t) {
                NoInternet.setValue(true);

            }
        });


    }
}