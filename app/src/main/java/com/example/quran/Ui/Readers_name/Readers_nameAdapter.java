package com.example.quran.Ui.Readers_name;
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

import com.bumptech.glide.Glide;
import com.example.quran.Models.ReadersNameModel;
import com.example.quran.R;

import com.example.quran.Ui.Surahs.SurahsFragments;
import com.example.quran.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Readers_nameAdapter extends RecyclerView.Adapter<Readers_nameAdapter.ViewHolder>{
    Readers_nameFragment readers_nameFragment;
    Fragment fragment = null;
    Class fragmentClass;
         List<ReadersNameModel.Data> Names=new ArrayList<>();
        Context context;
        public  Readers_nameAdapter(Readers_nameFragment readers_nameFragment,Context context, List<ReadersNameModel.Data> list){
            this.Names=list;
             this.readers_nameFragment=readers_nameFragment;
             this.context = context;
        }
        @NonNull
        @Override
        public Readers_nameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_readers_name, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.Name.setText(Names.get(position).getName()+"");
            holder.ItemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  fillSwarArray(Names.get(position).getSuras(),Names.get(position).getServer());
                Utils.ReaderName = Names.get(position).getName();
                Utils.IdReader =Names.get(position).getId();

               fragmentClass= SurahsFragments.class;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) { e.printStackTrace(); }
                FragmentManager fragmentManager = readers_nameFragment.getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Readers_nameFragment, fragment).commit();
            }
        });
        Glide.with(context)
                .asBitmap()
                .load("http://app.mp3quranplayer.com/user.jpg" +"")
                .into(holder.ReaderImage);
    }

/*    public void fillSwarArray(String Swars, String Server){
        List<String>Swar = new ArrayList<>();
        List<String>SwarId = new ArrayList<>();
        String str = Swars;
        String[] arrOfStr = str.split(",");
        String SwareUrl="";
        for(int i=0;i<arrOfStr.length;i++){
            SwarId.add(arrOfStr[i].toString());
            switch(arrOfStr[i].length()) {
                case 1:
                    SwareUrl = Server+"/00" + arrOfStr[i].toString() +".mp3";
                    break;
                case 2:
                    SwareUrl = Server+"/0" + arrOfStr[i].toString() +".mp3";
                    break;
                case 3:
                    SwareUrl = Server+"/" + arrOfStr[i].toString() +".mp3";
                    break;
            }
            Swar.add(SwareUrl);

        }
        Utils.SwarId = SwarId;
        Utils.Swar = Swar;
    }*/
    @Override
        public int getItemCount() {
            return Names.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            ConstraintLayout ItemName;
            TextView Name;
            ImageView ReaderImage;
            public ViewHolder(View itemView) {
                super(itemView);
                Name=itemView.findViewById(R.id.reader_name);
                ReaderImage=itemView.findViewById(R.id.readerImage);
                ItemName=itemView.findViewById(R.id.item_name);
            }

        }

    }
