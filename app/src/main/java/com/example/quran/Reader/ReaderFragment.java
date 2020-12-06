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

import java.io.IOException;

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
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(ReaderViewModel.class);
        if (container != null) {
            container.removeAllViews();
        }
        View root = inflater.inflate(R.layout.reader_fragment, container, false);
        slide_up = AnimationUtils.loadAnimation(getContext(), R.anim.slide);
        butt = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
        //  nameREader= root.findViewById(R.id.name);
        //   surah_name_ar= root.findViewById(R.id.surah_name_ar);
        surah_name_en = root.findViewById(R.id.surah_name_en);
        StartTime = root.findViewById(R.id.StartTime);
        EndTime = root.findViewById(R.id.EndTime);
        all_surah = root.findViewById(R.id.all_surah);
        Play_Pause = root.findViewById(R.id.play_pause);
        seekBar = root.findViewById(R.id.sBar);
        ((MainActivity) getActivity()).updateTextView(readername_ar);
        initAudioPlayer();
//        audioPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//              my_stop_play.setImageResource(R.drawable.play);
////                other_stop_play.setImageResource(R.drawable.play);
//
//            }
//        });
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
        //   all_surah.startAnimation(slide_up);
        Play_Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    if (audioPlayer!=null)
                    { stopAudio();
                        audioFileUrl="https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3";
                        try {
                            audioPlayer.setDataSource(audioFileUrl);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }catch (NullPointerException e){}
//                        audioPlayer.scv  etOnPreparedListener((MediaPlayer.OnPreparedListener) get);
                        audioPlayer.prepareAsync();
                        startAudio();
//                        viewHolder.my_stop_play.setImageResource(R.drawable.paus);
//                        viewHolder.other_stop_play.setImageResource(R.drawable.paus);
                    }else {
//                        audioFileUrl=messages.get(i);
                        startAudio();
//                        viewHolder.my_stop_play.setImageResource(R.drawable.play);
//                        viewHolder.other_stop_play.setImageResource(R.drawable.play);
                    }
             /*   if (!audioServiceBinder.audioPlayer.isPlaying()) {
                    audioServiceBinder.startAudio();
                    Play_Pause.setBackgroundResource(R.drawable.pause);
                      }else{
                    audioServiceBinder.pauseAudio();
                    Play_Pause.setBackgroundResource(R.drawable.play);
                }*/
                }
            }
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
    public void onPrepared(MediaPlayer player) {
        player.start();
    }
    public void startAudio()
    {
        initAudioPlayer();
        if(audioPlayer!=null) {
            audioPlayer.start();
        }
    }
    public boolean status=false;
    public void stopAudio()
    {
        if(audioPlayer!=null) {
            audioPlayer.stop();
            destroyAudioPlayer();
            status=false;
        }
    }

    private void destroyAudioPlayer()
    {
        status=false;
        if(audioPlayer!=null)
        {
            if(audioPlayer.isPlaying())
            {
                audioPlayer.stop();
            }
            audioPlayer.release();
            audioPlayer = null;
        }
    }

    public void initAudioPlayer()
    {
        try {
            if (audioPlayer == null) {
                audioPlayer = new MediaPlayer();
                if (!TextUtils.isEmpty(audioFileUrl)) {
                    audioPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    audioPlayer.setDataSource(audioFileUrl);
                    audioPlayer.prepare();

                }



            }

        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}