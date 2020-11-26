package com.example.quran.Surahs;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.quran.Models.SurahModel;
import java.util.ArrayList;
import java.util.List;
public class SurahsFragmentsViewModel extends ViewModel {
    MutableLiveData<List<SurahModel>> NamesSurahr=new MutableLiveData<>();
    public void GetSurahName() {
        List<SurahModel>surahModel=new ArrayList<>();
        List<String>names_ar=new ArrayList<>();
        names_ar.add("الفاتحه ");
        names_ar.add("البقره ");
        names_ar.add(" ال عمران ");
        for (int i=0;i<names_ar.size();i++){
            SurahModel surahNameModels=new SurahModel();
            surahNameModels.setName_ar(names_ar.get(i));
            surahNameModels.setName_en("Al-Baqarah");
            surahNameModels.setNumber("1");
            surahModel.add(surahNameModels);
        }
        NamesSurahr.setValue(surahModel);
    }}