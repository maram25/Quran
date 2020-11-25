package com.example.quran.Surah;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quran.Models.ReadersNameModel;
import com.example.quran.Models.SurahModel;
import com.example.quran.R;
import com.example.quran.Readers_name.Readers_nameAdapter;

import java.util.ArrayList;
import java.util.List;
public class SurahAdapter  extends RecyclerView.Adapter<SurahAdapter.ViewHolder>{
    List<SurahModel> Surah=new ArrayList<>();
        Context context;
        // this.context=context;
        public  SurahAdapter(Context context, List<SurahModel> list){
            this.Surah=list;
        }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_surah, parent, false);
            ViewHolder holder=new ViewHolder (view);
            return holder;
        }
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.Surah_name_ar.setText(Surah.get(position).getName_ar()+"");
            holder.Surah_name_en.setText(Surah.get(position).getName_en()+"");
            holder.NumberOfSurah.setText(Surah.get(position).getNumber()+"");
        }
    @Override

    public int getItemCount() {
            return Surah.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{

            TextView Surah_name_en,Surah_name_ar,NumberOfSurah;
            public ViewHolder(View itemView) {
                super(itemView);
                Surah_name_ar=itemView.findViewById(R.id.surah_name_ar);
                Surah_name_en=itemView.findViewById(R.id.surah_name_en);
                NumberOfSurah=itemView.findViewById(R.id.numberOfSurah);
            }

        }

}
