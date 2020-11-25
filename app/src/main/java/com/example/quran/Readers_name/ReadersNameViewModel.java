package com.example.quran.Readers_name;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quran.Models.ReadersNameModel;

import java.util.ArrayList;
import java.util.List;

public class ReadersNameViewModel extends ViewModel {

    MutableLiveData<List<ReadersNameModel>> NamesReader=new MutableLiveData<>();
    public void GetReadersName() {
        List<ReadersNameModel>readersNameModel=new ArrayList<>();
        List<String>names_ar=new ArrayList<>();
        names_ar.add("المنشاوي ");
        names_ar.add("المنشاوي ");
        names_ar.add("مشاري راشيد ");
        names_ar.add("عبد الرحمن السديسي ");
        names_ar.add("عبد الرحمن السديسي ");
        for (int i=0;i<names_ar.size();i++){
            ReadersNameModel readersNameModels=new ReadersNameModel();
            readersNameModels.setName_ar(names_ar.get(i));
            readersNameModels.setName_en("Meshary Rashid ");
            readersNameModels.setImage("https://www.pinterest.com/pin/835699274575479218/");
            readersNameModel.add(readersNameModels);

        }

        NamesReader.setValue(readersNameModel);
    }

}