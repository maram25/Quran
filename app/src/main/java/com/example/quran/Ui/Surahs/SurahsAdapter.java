package com.example.quran.Ui.Surahs;

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

import com.example.quran.R;
import com.example.quran.Ui.Reader.PlayerFragment;
import com.example.quran.Utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SurahsAdapter  extends RecyclerView.Adapter<SurahsAdapter.ViewHolder>{
        SurahsFragments surahsFragments;
        Fragment fragment = null;
        Class fragmentClass;
        List<String> Surah=new ArrayList<>();
        Context context;
        public  SurahsAdapter( SurahsFragments surahsFragments,Context context, List<String> list){
            this.context = context;
            this.Surah=list;
            this.surahsFragments=surahsFragments;
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
            holder.Surah_name.setText(getSwarName(Utils.SwarId.get(position)));
            holder.NumberOfSurah.setText(Utils.SwarId.get(position));

            holder.ItemSurah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentClass= PlayerFragment.class;
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
                Surah_name=itemView.findViewById(R.id.surah_name);
                NumberOfSurah=itemView.findViewById(R.id.numberOfSurah);
                ItemSurah=itemView.findViewById(R.id.item_saurahs);
            }

        }

        public  String getSwarName(String Swarid){
            String SwarName;
            try {
                JSONArray jArray = new JSONArray(readJSONFromAsset());
                for (int i = 0; i < jArray.length(); ++i) {
                    String id = jArray.getJSONObject(i).getString("id");
                    if (id.contains(Swarid)){
                        if (Utils.Lang.equals("ar"))
                            SwarName = jArray.getJSONObject(i).getString("name");
                        else
                             SwarName = jArray.getJSONObject(i).getString("name_en");

                        return  SwarName;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return  "0";
        }

        public String readJSONFromAsset() {
            String json = null;
            try {
                InputStream is = context.getAssets().open("swarArabic.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return json;
        }



    }