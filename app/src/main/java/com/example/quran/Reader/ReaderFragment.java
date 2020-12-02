package com.example.quran.Reader;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quran.R;
import com.example.quran.Surahs.SurahsFragments;

import java.io.IOException;
import java.util.ArrayList;

public class ReaderFragment extends Fragment {

    private ReaderViewModel mViewModel;

    public static ReaderFragment newInstance() {
        return new ReaderFragment();
    }
    TextView nameREader,surah_name_ar,surah_name_en,StartTime,EndTime;
    LinearLayout all_surah;
    ImageView Play_Pause;
    SeekBar seekBar;
    MediaPlayer player = new MediaPlayer();
  //  ArrayList <MusicFiles> listion=new ArrayList<musicFile>();
    String Url;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(ReaderViewModel.class);

        if (container != null) {
            container.removeAllViews();
        }
        View root=inflater.inflate(R.layout.reader_fragment, container, false);

      //  nameREader= root.findViewById(R.id.name);
     //   surah_name_ar= root.findViewById(R.id.surah_name_ar);
        surah_name_en= root.findViewById(R.id.surah_name_en);
        StartTime= root.findViewById(R.id.StartTime);
        EndTime= root.findViewById(R.id.EndTime);
        all_surah= root.findViewById(R.id.all_surah);
        Play_Pause= root.findViewById(R.id.play_pause);
        seekBar= root.findViewById(R.id.sBar);
        all_surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
               fragment = new SurahsFragments();
                replaceFragment(fragment); }
        });
        Play_Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {

                  //  MediaPlayer mp = MediaPlayer.create(this,R.raw.Nas);
                  //  mp.start();

                    player.start();
                    // player.setDataSource("https://www.youtube.com/watch?v=hBql4kQzta");
                   // String audioUrl = "https://www.youtube.com/watch?v=hBql4kQzta";
                 //   try { player.setDataSource(audioUrl); } catch (IOException e) { e.printStackTrace(); }

             /*   if (!audioServiceBinder.audioPlayer.isPlaying()) {
                    audioServiceBinder.startAudio();
                    Play_Pause.setBackgroundResource(R.drawable.pause);
                      }else{
                    audioServiceBinder.pauseAudio();
                    Play_Pause.setBackgroundResource(R.drawable.play);
                }*/
              //      player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                       //     Toast.makeText(Context, "End", Toast.LENGTH_SHORT).show();
                            Play_Pause.setEnabled(true);
                        }
                    });
                }}
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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