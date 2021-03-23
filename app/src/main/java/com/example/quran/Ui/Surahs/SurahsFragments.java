package com.example.quran.Ui.Surahs;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quran.MainActivity;
import com.example.quran.Models.SurahModel;
import com.example.quran.R;
import com.example.quran.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.Util;

public class SurahsFragments extends Fragment {
    private Object SurahModel;

    public static SurahsFragments newInstance() {
        return new SurahsFragments();
    }

    private SurahsFragmentsViewModel mViewModel;
    Context context;
    RecyclerView SurahName;
    SurahsFragments surahsFragments=this;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      ////  if(!(Utils.position.get(Utils.position.size()-1).equals("surahs"))) Utils.position.add("surahs");
        mViewModel = new ViewModelProvider(this).get(SurahsFragmentsViewModel.class);
        if (container != null) {
            container.removeAllViews();
        }
        context = getContext();
        View root=inflater.inflate(R.layout.surahs_fragments_fragment, container, false);
        SurahName=root.findViewById(R.id.surah_recycle);
        ((MainActivity) getActivity()).updateTextView(Utils.ReaderName);
        mViewModel.GetSurahName();

        mViewModel.NamesSurahr.observe(getViewLifecycleOwner(), new Observer<List<SurahModel.Data>>() {
            @Override
            public void onChanged(List<SurahModel.Data> data) {
                Utils.Link_audioTitles = new ArrayList<>();
                Utils.Link_audio = new ArrayList<>();
                for ( int i = 0 ; i< data.size() ; i++){
                    Utils.Link_audio.add(data.get(i).getLink());
                    Utils.Link_audioTitles.add(data.get(i).getName());

                }
                final SurahsAdapter adapter =new  SurahsAdapter(getActivity().getSupportFragmentManager(),context,data);
                SurahName.setLayoutManager(new GridLayoutManager(getContext(),1));
                SurahName.setAdapter(adapter);
              }
        });
        return root;
    }



}