package com.example.quran.Readers_name;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quran.Models.ReadersNameModel;
import com.example.quran.R;
import com.bumptech.glide.Glide;
import com.example.quran.Surah.SurahFragment;


import java.util.ArrayList;
import java.util.List;

public class Readers_nameAdapter extends RecyclerView.Adapter<Readers_nameAdapter.ViewHolder>{
    Readers_nameFragment readers_nameFragment;
    Fragment fragment = null;
    Class fragmentClass;
         List<ReadersNameModel> Names=new ArrayList<>();
        Context context;
        //            this.context=context;
        public  Readers_nameAdapter(Readers_nameFragment readers_nameFragment,Context context, List<ReadersNameModel> list){
            this.Names=list;
             this.readers_nameFragment=readers_nameFragment;
        }
        @NonNull
        @Override
        public Readers_nameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_readers_name, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.Name_ar.setText(Names.get(position).getName_ar()+"");
            holder.Name_en.setText(Names.get(position).getName_en()+"");

        try {
            Glide.with(context)
                    .asBitmap()
                    .load("https://api.sadrad.app/uploads/cars/" + Names.get(position).getImage()+ "")
                    .into(holder.ReaderImage);
        }catch (NullPointerException e){};


        holder.ItemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Utils.trip_id = offersModelList.trips.get(position).getId();
                fragmentClass= SurahFragment.class;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }// Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = readers_nameFragment.getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Readers_nameFragment, fragment).commit();

            }
        });
    }

        @Override
        public int getItemCount() {
            return Names.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            ConstraintLayout ItemName;
            TextView Name_en,Name_ar;
            ImageView ReaderImage;
            public ViewHolder(View itemView) {
                super(itemView);
                Name_ar=itemView.findViewById(R.id.reader_name_ar);
                Name_en=itemView.findViewById(R.id.reader_name_en);
                ReaderImage=itemView.findViewById(R.id.readerImage);
                ItemName=itemView.findViewById(R.id.item_name);
            }

        }

    }
