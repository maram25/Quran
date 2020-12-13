package com.example.quran.Ui.Reader;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.quran.MainActivity;
import com.example.quran.R;
import com.example.quran.Ui.Surahs.SurahsFragments;
import com.example.quran.Utils.Utils;
import com.keenfin.audioview.AudioView;

import java.util.ArrayList;
import java.util.List;

public class PlayerFragment extends Fragment {
    private ReaderViewModel mViewModel;
    public static PlayerFragment newInstance() {
        return new PlayerFragment();
    }

    LinearLayout all_surah;
    Animation slide_up, butt;
    String readername_ar = "مشاري";
    String readername_en = "Mishary Rashid";
    AudioView audioView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(!(Utils.position.get(Utils.position.size()-1).equals("Player")))
            Utils.position.add("Player");
        mViewModel = new ViewModelProvider(this).get(ReaderViewModel.class);
        if (container != null) {
            container.removeAllViews();
        }
        View root = inflater.inflate(R.layout.reader_fragment, container, false);
        audioView = root.findViewById(R.id.AV);

        slide_up = AnimationUtils.loadAnimation(getContext(), R.anim.slide);
        butt = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
        all_surah = root.findViewById(R.id.all_surah);
        if(Utils.Lang.equals("ar")){
            ((MainActivity) getActivity()).updateTextView(readername_ar);
        }
        if(Utils.Lang.equals("en")){
            ((MainActivity) getActivity()).updateTextView(readername_en);
        }


        List<String> Audios = new ArrayList<>();
        Audios.add("https://server13.mp3quran.net/husr/112.mp3");
        Audios.add("https://server12.mp3quran.net/maher/112.mp3");
        Audios.add("https://server10.mp3quran.net/ajm/112.mp3");
        Audios.add("https://server8.mp3quran.net/bna/112.mp3");
        Audios.add("https://server8.mp3quran.net/bna/112.mp3");
        Audios.add("https://server10.mp3quran.net/minsh/112.mp3");

        audioView.setDataSource(Utils.Swar);
        all_surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new SurahsFragments();
                replaceFragment(fragment);

                all_surah.startAnimation(butt);
            }
        });

        return root;
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.readerFragment, someFragment);
        transaction.addToBackStack("");
        transaction.commit();
    }




}