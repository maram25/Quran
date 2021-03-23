package com.example.quran.Ui.Surahs;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quran.Models.ReadersNameModel;
import com.example.quran.Models.SurahModel;
import com.example.quran.R;
import com.example.quran.Ui.Player.PlayerFragment;
import com.example.quran.Utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SurahsAdapter  extends RecyclerView.Adapter<SurahsAdapter.ViewHolder>{
        Fragment fragment = null;
        Class fragmentClass;
        FragmentManager fragmentManager;
       // List<String> Surah=new ArrayList<>();
        List<SurahModel.Data> NamesSurah=new ArrayList<>();

    Context context;
        public  SurahsAdapter(FragmentManager fragmentManager, Context context, List<SurahModel.Data> list){
            this.NamesSurah=list;
            this.context = context;
            this.fragmentManager = fragmentManager;
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
            holder.Surah_name.setText(NamesSurah.get(position).getName());
            holder.NumberOfSurah.setText(NamesSurah.get(position).getId());
//            Utils.TitleOfSurah=NamesSurah.get(position).getName();
//            Utils.Link_audio=NamesSurah.get(position).getLink();
            holder.ItemSurah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentClass= PlayerFragment.class;
                 //   Utils.TitleOfSurah=NamesSurah.get(position).getName();
//                  Utils.Link_audioTitles=NamesSurah.get(position).getName();
                    Utils.AudioIndex=position;
                    Log.e("testUtils.TitleOfSurah",Utils.Link_audioTitles.get(position)+" ");
                    Log.e("testUtils.TitleOfSurah",Utils.Link_audio+" ");

                    Blackout(new PlayerFragment());

                }
            });
            holder.Downloud.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DownloadManager mManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri= Uri.parse(Utils.Link_audio.get(position));
                     DownloadManager.Request request=new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    Long refrencee=mManager.enqueue(request);
                }
            });
            holder.Play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
        @Override
        public int getItemCount() {
            return NamesSurah.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            ConstraintLayout ItemSurah;
            TextView Surah_name,Surah_name_ar,NumberOfSurah;
            ImageView Downloud,Play;
            public ViewHolder(View itemView) {
                super(itemView);
                Surah_name=itemView.findViewById(R.id.surah_name);
                NumberOfSurah=itemView.findViewById(R.id.numberOfSurah);
                ItemSurah=itemView.findViewById(R.id.item_saurahs);
                Surah_name_ar=itemView.findViewById(R.id.surah_name_en);
                Downloud=itemView.findViewById(R.id.downloud);
                Play=itemView.findViewById(R.id.play);
            }
        }

    private void Blackout(Fragment fragment) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.main, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
/*

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
                        Utils.SurahName=SwarName;

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
*/

    }