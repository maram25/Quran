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
import com.example.quran.R;
import com.example.quran.Utils.Utils;

import java.util.List;

public class SurahsFragments extends Fragment {
    public static SurahsFragments newInstance() {
        return new SurahsFragments();
    }

    private SurahsFragmentsViewModel mViewModel;
    Context context;
    RecyclerView SurahName;
    SurahsFragments surahsFragments=this;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      //  if(!(Utils.position.get(Utils.position.size()-1).equals("c"))) Utils.position.add("surahs");
        if(!(Utils.position.get(Utils.position.size()-1).equals("surahs")))
            Utils.position.add("surahs");

        mViewModel = new ViewModelProvider(this).get(SurahsFragmentsViewModel.class);

        if (container != null) {
            container.removeAllViews();
        }
        context = getContext();

        View root=inflater.inflate(R.layout.surahs_fragments_fragment, container, false);
        SurahName=root.findViewById(R.id.surah_recycle);



        ((MainActivity) getActivity()).updateTextView(Utils.ReaderName);

        mViewModel.GetSurahName();

        mViewModel.NamesSurahr.observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> surahModels) {
                final SurahsAdapter adapter =new  SurahsAdapter(surahsFragments,context,surahModels);
                SurahName.setLayoutManager(new GridLayoutManager(getContext(),1));
                SurahName.setAdapter(adapter);
            }
        });


        return root;
    }



}