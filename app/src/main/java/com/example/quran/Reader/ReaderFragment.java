package com.example.quran.Reader;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quran.R;
import com.example.quran.Surahs.SurahsFragments;

public class ReaderFragment extends Fragment {

    private ReaderViewModel mViewModel;

    public static ReaderFragment newInstance() {
        return new ReaderFragment();
    }
    TextView nameREader,surah_name_ar,surah_name_en,StartTimem,EndTime;
    LinearLayout all_surah;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(ReaderViewModel.class);
        View root=inflater.inflate(R.layout.reader_fragment, container, false);

      nameREader= root.findViewById(R.id.name);
        surah_name_ar= root.findViewById(R.id.surah_name_ar);
        surah_name_en= root.findViewById(R.id.surah_name_en);
        StartTimem= root.findViewById(R.id.StartTime);
        EndTime= root.findViewById(R.id.EndTime);
        all_surah= root.findViewById(R.id.all_surah);
        all_surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
               fragment = new SurahsFragments();
                replaceFragment(fragment); }
        });


        return root;
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.readerFragment, someFragment);
        transaction.addToBackStack("");
        transaction.commit();
    }


}