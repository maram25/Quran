package com.example.quran.Readers_name;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toolbar;
import com.example.quran.Models.ReadersNameModel;
import com.example.quran.R;
import com.example.quran.SwitchLang;

import java.util.List;

public class Readers_nameFragment extends Fragment {

    private ReadersNameViewModel mViewModel;

    public static Readers_nameFragment newInstance() {
        return new Readers_nameFragment();
    }
    Readers_nameFragment readers_nameFragment =this;
    Context context;
    Menu optionsMenu;
ImageView edi;
    RecyclerView ReadersName;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        context = getContext();
            View root=inflater.inflate(R.layout.readers_name_fragment, container, false);
            mViewModel = new ViewModelProvider(this).get(ReadersNameViewModel.class);
           ReadersName=root.findViewById(R.id.readers_recycle);
           mViewModel.GetReadersName();
           edi=root.findViewById(R.id.edit);
           mViewModel.NamesReader.observe(this, new Observer<List<ReadersNameModel>>() {
               @Override
               public void onChanged(List<ReadersNameModel> readersNameModels) {

                   final Readers_nameAdapter adapter= new Readers_nameAdapter(readers_nameFragment,context,readersNameModels);
                   ReadersName.setLayoutManager( new GridLayoutManager(getContext(),1));
                   ReadersName.setAdapter(adapter);
               }
           });
           edi.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(context,SwitchLang.class);
                   startActivity(intent);

               }
           });
        return root;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.bar,menu);
        menu.findItem(R.id.menuEdit).setVisible(true);
        optionsMenu = menu;
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuEdit:
                Intent intent = new Intent(context, SwitchLang.class);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}