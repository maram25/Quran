package com.example.quran.Reader;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.quran.MainActivity;
import com.example.quran.R;
import com.example.quran.Surahs.SurahsFragments;
import com.keenfin.audioview.AudioView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFragment extends Fragment {
    private ReaderViewModel mViewModel;
    public static ReaderFragment newInstance() {
        return new ReaderFragment();
    }

    TextView nameREader, surah_name_ar, surah_name_en, StartTime, EndTime;
    LinearLayout all_surah;
    ImageView Play_Pause;
    SeekBar seekBar;
    Animation slide_up, butt;
    MediaPlayer player = new MediaPlayer();
    //  ArrayList <MusicFiles> listion=new ArrayList<musicFile>();
    String Url;
    String readername_ar = "مشاري";
    public String audioFileUrl = "";
    public static MediaPlayer audioPlayer = null;

    MediaPlayer mp = new MediaPlayer();

    AudioView audioView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(ReaderViewModel.class);
        if (container != null) {
            container.removeAllViews();
        }
        View root = inflater.inflate(R.layout.reader_fragment, container, false);
        audioView = root.findViewById(R.id.AV);

        slide_up = AnimationUtils.loadAnimation(getContext(), R.anim.slide);
        butt = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
        all_surah = root.findViewById(R.id.all_surah);

        ((MainActivity) getActivity()).updateTextView(readername_ar);
        List<String> Audios = new ArrayList<>();

        Audios.add("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3");
        Audios.add("https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3");
        Audios.add("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-16.mp3");

        audioView.setDataSource(Audios);
        all_surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new SurahsFragments();
                replaceFragment(fragment);

                // all_surah.startAnimation(slide_up);
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