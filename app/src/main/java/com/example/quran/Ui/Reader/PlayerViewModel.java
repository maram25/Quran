package com.example.quran.Ui.Reader;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quran.Utils.Utils;

import java.util.List;

public class PlayerViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    MutableLiveData<List<String>> NamesSurahr=new MutableLiveData<>();
    public void GetSurahName() {

        NamesSurahr.setValue(Utils.Swar);
       // NamesSurahr.setValue(Utils.SurahName);
    }
}