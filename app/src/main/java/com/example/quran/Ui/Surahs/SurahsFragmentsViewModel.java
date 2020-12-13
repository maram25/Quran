package com.example.quran.Ui.Surahs;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quran.Utils.Utils;

import java.util.List;
public class SurahsFragmentsViewModel extends ViewModel {
    MutableLiveData<List<String>> NamesSurahr=new MutableLiveData<>();
    public void GetSurahName() {

        NamesSurahr.setValue(Utils.Swar);
    }
}