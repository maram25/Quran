package com.example.quran.Ui.Readers_name;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.quran.Models.ReadersNameModel;
import com.example.quran.R;
import com.example.quran.Utils.Utils;

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
//       if(!(Utils.position.get(Utils.position.size()-1).equals("Readers")))
            Utils.position.add("Readers");
        if (container != null) {
            container.removeAllViews();
        }
            context = getContext();
            View root=inflater.inflate(R.layout.readers_name_fragment, container, false);
            mViewModel = new ViewModelProvider(this).get(ReadersNameViewModel.class);
           ReadersName=root.findViewById(R.id.readers_recycle);
           mViewModel.GetReadersName();
           edi=root.findViewById(R.id.edit);
           mViewModel.NamesReader.observe(this, new Observer<List<ReadersNameModel.Data>>()  {
               @Override
               public void onChanged(List<ReadersNameModel.Data> readersNameModels) {
                   Log.e("tst",readersNameModels.size()+" nu");
                   final Readers_nameAdapter adapter= new Readers_nameAdapter(readers_nameFragment,context,readersNameModels);
                   ReadersName.setLayoutManager( new GridLayoutManager(getContext(),1));
                   ReadersName.setAdapter(adapter);
               }
           });
           /*edi.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(context,SwitchLang.class);
                   startActivity(intent);
               }
           });*/
        return root;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.bar,menu);
       // menu.findItem(R.id.menuEdit).setVisible(true);
        optionsMenu = menu;
        super.onCreateOptionsMenu(menu, inflater);
    }

}