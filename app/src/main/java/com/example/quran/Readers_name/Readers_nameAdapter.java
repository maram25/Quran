package com.example.quran.Readers_name;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quran.Models.ReadersNameModel;
import com.example.quran.R;
import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

public class Readers_nameAdapter extends RecyclerView.Adapter<Readers_nameAdapter.ViewHolder>{
         List<ReadersNameModel> Names=new ArrayList<>();
        Context context;
        //            this.context=context;
        public  Readers_nameAdapter(Context context, List<ReadersNameModel> list){
            this.Names=list;
        }
        @NonNull
        @Override
        public Readers_nameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_readers_name, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            //   holder.FromCity.setText("From "+MyTrips.data.get(position).packupcity.getCity_name_en());
            holder.Name_ar.setText(Names.get(position).getName_ar()+"");
            holder.Name_en.setText(Names.get(position).getName_en()+"");

        try {
            Glide.with(context)
                    .asBitmap()
                    .load("https://api.sadrad.app/uploads/cars/" + Names.get(position).getImage()+ "")
                    .into(holder.ReaderImage);
        }catch (NullPointerException e){};
    //    holder.Name_ar.setText();
    }

        @Override
        public int getItemCount() {
            return Names.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{

            TextView Name_en,Name_ar;
            ImageView ReaderImage;
            public ViewHolder(View itemView) {
                super(itemView);
                Name_ar=itemView.findViewById(R.id.reader_name_ar);
                Name_en=itemView.findViewById(R.id.reader_name_en);
                ReaderImage=itemView.findViewById(R.id.readerImage);
            }

        }

    }
