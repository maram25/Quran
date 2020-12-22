package com.example.quran.Ui.Readers_name;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quran.Models.ReadersNameModel;
import com.example.quran.Utils.Utils;
import com.example.quran.data.APIClient;
import com.example.quran.data.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadersNameViewModel extends ViewModel {
    MutableLiveData<List<ReadersNameModel.Data>> NamesReader=new MutableLiveData<>();
    MutableLiveData<Boolean> NoInternet=new MutableLiveData<>();

    APIInterface apiInterface;
    public void GetReadersName() {

       // apiInterface = APIClient.getClient("http://mp3quran.net/api/").create(APIInterface.class);
        apiInterface  = APIClient.getClient().create(APIInterface.class);
        Call<ReadersNameModel> call=apiInterface.get_Readers(Utils.Lang);
        call.enqueue(new Callback<ReadersNameModel>() {
            @Override
            public void onResponse(Call<ReadersNameModel> call, Response<ReadersNameModel> response) {
                if( response.isSuccessful()){
                    NamesReader.setValue(response.body().data);
                }}
            @Override
            public void onFailure(Call<ReadersNameModel> call, Throwable t) {
                NoInternet.setValue(true);

            }
        });

    }

}