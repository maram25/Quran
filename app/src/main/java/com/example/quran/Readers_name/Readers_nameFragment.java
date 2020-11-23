package com.example.quran.Readers_name;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quran.R;

public class Readers_nameFragment extends Fragment {

    private ReadersNameViewModel mViewModel;

    public static Readers_nameFragment newInstance() {
        return new Readers_nameFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

            View root=inflater.inflate(R.layout.readers_name_fragment, container, false);
            mViewModel = new ViewModelProvider(this).get(ReadersNameViewModel.class);


        return root;
    }

}