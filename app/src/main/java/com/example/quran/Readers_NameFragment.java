package com.example.quran;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Readers_NameFragment extends Fragment {

    private ReadersNameViewModel mViewModel;

    public static Readers_NameFragment newInstance() {
        return new Readers_NameFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(ReadersNameViewModel.class);

        View root=    inflater.inflate(R.layout.readers__name_fragment, container, false);


        return root;
    }

}