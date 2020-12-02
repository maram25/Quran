package com.example.quran.Surahs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quran.Models.SurahModel;
import com.example.quran.R;
import com.example.quran.Reader.ReaderFragment;
import com.example.quran.Readers_name.Readers_nameFragment;

import java.util.ArrayList;
import java.util.List;

    public class SurahsAdapter  extends RecyclerView.Adapter<SurahsAdapter.ViewHolder>{
        SurahsFragments surahsFragments;
        Fragment fragment = null;
        Class fragmentClass;
        List<SurahModel> Surah=new ArrayList<>();
        Context context;
        // this.context=context;
        public  SurahsAdapter( SurahsFragments surahsFragments,Context context, List<SurahModel> list){
            this.Surah=list;
            this.surahsFragments=surahsFragments; }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_surah, parent, false);
            ViewHolder holder=new ViewHolder (view);
            return holder;
        }
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.Surah_name.setText(Surah.get(position).getName_ar()+"");
          //  holder.Surah_name_en.setText(Surah.get(position).getName_en()+"");
            holder.NumberOfSurah.setText(Surah.get(position).getNumber()+"");

            holder.ItemSurah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //   Utils.trip_id = offersModelList.trips.get(position).getId();
                    fragmentClass= ReaderFragment.class;
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }// Insert the fragment by replacing any existing fragment
                    FragmentManager fragmentManager = surahsFragments.getActivity().getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.SurahFragment, fragment).commit();
                }
            });
        }
        @Override

        public int getItemCount() {
            return Surah.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            ConstraintLayout ItemSurah;

            TextView Surah_name,Surah_name_ar,NumberOfSurah;
            public ViewHolder(View itemView) {
                super(itemView);
               // Surah_name_ar=itemView.findViewById(R.id.surah_name_ar);
                Surah_name=itemView.findViewById(R.id.surah_name);
                NumberOfSurah=itemView.findViewById(R.id.numberOfSurah);
                ItemSurah=itemView.findViewById(R.id.item_saurahs);
            }

        }


    }