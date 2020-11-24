package com.example.quran.Readers_name;

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

import com.example.quran.Models.ReadersNameModel;
import com.example.quran.R;

import java.util.List;

public class Readers_nameFragment extends Fragment {

    private ReadersNameViewModel mViewModel;

    public static Readers_nameFragment newInstance() {
        return new Readers_nameFragment();
    }
    Context context;
    RecyclerView ReadersName;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }
        context = getContext();
            View root=inflater.inflate(R.layout.readers_name_fragment, container, false);
            mViewModel = new ViewModelProvider(this).get(ReadersNameViewModel.class);
           ReadersName=root.findViewById(R.id.readers_recycle);
           mViewModel.GetReadersName();
           mViewModel.NamesReader.observe(this, new Observer<List<ReadersNameModel>>() {
               @Override
               public void onChanged(List<ReadersNameModel> readersNameModels) {

                   final Readers_nameAdapter adapter= new Readers_nameAdapter(context,readersNameModels);
                   ReadersName.setLayoutManager( new GridLayoutManager(getContext(),1));
                   ReadersName.setAdapter(adapter);
               }
           });


        return root;
    }

}