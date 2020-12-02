package com.example.quran.Surahs;

import androidx.fragment.app.FragmentTransaction;
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

import com.example.quran.Models.SurahModel;
import com.example.quran.R;

import java.util.List;

public class SurahsFragments extends Fragment {
    private SurahsFragmentsViewModel mViewModel;
    Context context;
    RecyclerView SurahName;
    SurahsFragments surahsFragments=this;

    public static SurahsFragments newInstance() {
        return new SurahsFragments();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        context = getContext();
        View root=inflater.inflate(R.layout.surahs_fragments_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(SurahsFragmentsViewModel.class);
        SurahName=root.findViewById(R.id.surah_recycle);
        mViewModel.GetSurahName();
        mViewModel.NamesSurahr.observe(this, new Observer<List<SurahModel>>() {
            @Override
            public void onChanged(List<SurahModel> surahModels) {
                final SurahsAdapter adapter =new  SurahsAdapter(surahsFragments,context,surahModels);
                SurahName.setLayoutManager(new GridLayoutManager(getContext(),1));
                SurahName.setAdapter(adapter);
            }
        });
        return root;
    }

    private void goToFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack("");
        }
        transaction.add(R.id.container, fragment).commit();
    }

}