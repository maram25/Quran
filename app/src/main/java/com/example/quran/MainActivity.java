package com.example.quran;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quran.Notification.CreatNotification;
import com.example.quran.Notification.Track;
import com.example.quran.Ui.Player.PlayerFragment;
import com.example.quran.Ui.Readers_name.Readers_nameFragment;
import com.example.quran.Ui.Surahs.SurahsFragments;
import com.example.quran.Utils.Utils;
import java.util.List;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Menu optionsMenu;
    ImageView edit;
    static TextView nameReader;
/////////////////////////
    ImageButton play;
    TextView title;
    NotificationManager notificationManager;
    List<Track> tracks;
    int position = 0;
    boolean isPlaying = false;

    ////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit=findViewById(R.id.edit);
        nameReader=findViewById(R.id.name_reader);
        nameReader.setText("Quran");
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SwitchLang.class);
                startActivity(myIntent);
            }
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main, Readers_nameFragment.newInstance()).commitNow();
        }
        ///////////////////////////
        /*Play = findViewById(R.id.play);
        title = findViewById(R.id.title);
        popluateTracks();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
            registerReceiver(broadcastReceiver, new IntentFilter("TRACKS_TRACKS"));
            startService(new Intent(getBaseContext(),OnClearFromRecentService.class));
        }
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying) {
                    onTrackPause();
                } else {
//                    CreateNotification.createNotification(MainActivity.this, tracks.get(1), R.drawable.ic_pause_black_24dp,
//                            1, tracks.size() - 1);
                    onTrackPlay();
                }
            }
        });

    private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CreatNotification.CHANNEL_ID, "Creates Apps", NotificationManager.IMPORTANCE_LOW);
            notificationManager = getSystemService(NotificationManager.class);

            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
    }
    //popular list with tracks
    private void popluateTracks() {
//        tracks = new ArrayList<>();
//        tracks.add(new Track("Tracks 1", "Artist 1", R.drawable.ti));
//        tracks.add(new Track("Tracks 2", "Artist 2", R.drawable.t2));
//        tracks.add(new Track("Tracks 3", "Artist 3", R.drawable.t3));
//        tracks.add(new Track("Tracks 4", "Artist 4", R.drawable.t4));
    }
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getExtras().getString("actionname");
            switch (action) {
                case CreatNotification.ACTION_PREVIOUS:
                    onTrackPause();
                    break;
                case CreatNotification.ACTION_PLAY:
                    if (isPlaying) {
                        onTrackPause();
                    } else {
                        onTrackPlay();
                    }
                    break;
                case CreatNotification.ACTION_NEXT:
                    onTrackNext();
                    break;
            }
        }
    };
    @Override
    public void onTrackPrevious() {
        position--;
        CreatNotification.createNotification(MainActivity.this, tracks.get(position), R.drawable.pause2, position, tracks.size() - 1);
        title.setText(tracks.get(position).getTitle());
    }
    @Override
    public void onTrackPlay() {
        CreatNotification.createNotification(MainActivity.this, tracks.get(position), R.drawable.pause2, position, tracks.size() - 1);
        play.setImageResource(R.drawable.pause2);
        title.setText(tracks.get(position).getTitle());
        isPlaying = true;
    }
    @Override
    public void onTrackPause() {
        CreatNotification.createNotification(MainActivity.this, tracks.get(position), R.drawable.play, position, tracks.size() - 1);
        play.setImageResource(R.drawable.pause2);
        title.setText(tracks.get(position).getTitle());
        isPlaying = false;
    }
    @Override
    public void onTrackNext() {
        position++;
        CreatNotification.createNotification(MainActivity.this, tracks.get(position),
                R.drawable.pause2, position, tracks.size() - 1);
        title.setText(tracks.get(position).getTitle());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.cancelAll();
        }
        unregisterReceiver(broadcastReceiver);
    }*/
        ////////////////////////////
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar, menu);
        optionsMenu = menu;
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            return super.onOptionsItemSelected(item);
        }
    public void updateTextView(String i) {
        nameReader.setText(i);
    }
    Class fragmentClass;
    @Override
    public void onBackPressed() {
        Fragment fragment = null;
            try {
                if (Utils.position.get(Utils.position.size() - 2).equals("Readers")) {

                    fragmentClass = Readers_nameFragment.class;

                } else if (Utils.position.get(Utils.position.size() - 2).equals("Player")) {

                    fragmentClass = PlayerFragment.class;

                } else if (Utils.position.get(Utils.position.size() - 2).equals("surahs")) {
                    fragmentClass = SurahsFragments.class;

                }
            }catch (IndexOutOfBoundsException e){
                Log.e("finish1","finish1");

                this.finish();
                System.exit(0);
            }
            Log.e("back", "ms7t");
            Utils.position.remove(Utils.position.size() - 1);
            try {
                Utils.position.remove(Utils.position.size() - 2);

            }catch (IndexOutOfBoundsException e){}

            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }// Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main, fragment).commit();
        }

    }

