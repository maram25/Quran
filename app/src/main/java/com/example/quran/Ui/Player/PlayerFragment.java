package com.example.quran.Ui.Player;

import androidx.fragment.app.FragmentTransaction;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.quran.MainActivity;
import com.example.quran.R;
import com.example.quran.Ui.Surahs.SurahsAdapter;
import com.example.quran.Ui.Surahs.SurahsFragments;
import com.example.quran.Utils.Utils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.keenfin.audioview.AudioView;

import java.util.ArrayList;
import java.util.List;

public class PlayerFragment extends Fragment {
    private PlayerViewModel mViewModel;
    public static PlayerFragment newInstance() {
        return new PlayerFragment();
    }

    BottomSheetBehavior bottomSheetBehavior;
    LinearLayout all_surah;
    Animation slide_up, butt;
    String readername_ar = "مشاري";
    String readername_en = "Mishary Rashid";
    AudioView audioView;
    ImageView play,rewind,forward,back,loop;
    ////
    RecyclerView SurahName;
    Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(!(Utils.position.get(Utils.position.size()-1).equals("Player")))
            Utils.position.add("Player");
        mViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);
        if (container != null) {
            container.removeAllViews();
        }
        View root = inflater.inflate(R.layout.player_fragment, container, false);
        audioView = root.findViewById(R.id.AV);
        View bottomSuraha = root.findViewById(R.id.bottom_suraha);

        slide_up = AnimationUtils.loadAnimation(getContext(), R.anim.slide);
        butt = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
        all_surah = root.findViewById(R.id.all_surah);
        play=root.findViewById(R.id.play);
        rewind=root.findViewById(R.id.rewind);
        forward=root.findViewById(R.id.forward);
        loop=root.findViewById(R.id.loop);
        SurahName=root.findViewById(R.id.surah_recycle);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSuraha);
      //  back_down=root.findViewById(R.id.back_down);
        back=root.findViewById(R.id.back_up);
        if(Utils.Lang.equals("ar")){
            ((MainActivity) getActivity()).updateTextView(Utils.ReaderName);
            rewind.setImageResource(R.drawable.next);
            forward.setImageResource(R.drawable.following);
        }
        if(Utils.Lang.equals("en")){
            ((MainActivity) getActivity()).updateTextView(Utils.ReaderName);
        }

        List<String> Audios = new ArrayList<>();
        Audios.add("https://server13.mp3quran.net/husr/112.mp3");
        Audios.add("https://server12.mp3quran.net/maher/112.mp3");
        Audios.add("https://server10.mp3quran.net/ajm/112.mp3");
        Audios.add("https://server8.mp3quran.net/bna/112.mp3");
        Audios.add("https://server8.mp3quran.net/bna/112.mp3");
        Audios.add("https://server10.mp3quran.net/minsh/112.mp3");
        audioView.setDataSource(Utils.Swar);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioView.nextTrack();

            }});
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioView.previousTrack();
            }
        });

        loop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* boolean run = true;
                while(run)
                {
                }

                audioView.setDataSource(Utils.Swar);
                audioView.start();*/

            }
        });

        ///////////////
        if (Audios.size()>0) {
            /*SurahsFragments surahsFragments=null;
            final SurahsAdapter adapter =new  SurahsAdapter(surahsFragments,context,surahModels);
            SurahName.setLayoutManager(new GridLayoutManager(getContext(),1));
            SurahName.setAdapter(adapter);
            SurahName.setLayoutManager(new LinearLayoutManager(getContext()));
*/
            mViewModel.GetSurahName();
            mViewModel.NamesSurahr.observe(this, new Observer<List<String>>() {
                @Override
                public void onChanged(List<String> surahModels) {
                    SurahsFragments surahsFragments = null;
                    context = getContext();
                    final SurahsAdapter adapter =new  SurahsAdapter(surahsFragments,context,surahModels);
                    SurahName.setLayoutManager(new GridLayoutManager(getContext(),1));
                    SurahName.setAdapter(adapter);
                }
            });
        }
        ///////////////////
        setup();

        /*
        all_surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new SurahsFragments();
                replaceFragment(fragment);

                all_surah.startAnimation(butt);
            }
        });*/
///////////
     /*
        mViewModel.GetSurahName();
        mViewModel.NamesSurahr.observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> surahModels) {
                SurahsFragments surahsFragments = null;
                context = getContext();
                final SurahsAdapter adapter =new  SurahsAdapter(surahsFragments,context,surahModels);
                SurahName.setLayoutManager(new GridLayoutManager(getContext(),1));
                SurahName.setAdapter(adapter);
            }
        });*/
////////////////////////////////////////
        return root;
    }
         private void setup() {
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    back.setImageResource(R.drawable.back_up);
                } else if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    back.setImageResource(R.drawable.back_down);
                }else if(newState == BottomSheetBehavior.STATE_HIDDEN){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }});}
            public void replaceFragment(Fragment someFragment) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.readerFragment, someFragment);
            transaction.addToBackStack("");
          transaction.commit();
    }
}