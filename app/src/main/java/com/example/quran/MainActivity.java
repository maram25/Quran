package com.example.quran;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quran.Ui.Reader.PlayerFragment;
import com.example.quran.Ui.Readers_name.Readers_nameFragment;
import com.example.quran.Ui.Surahs.SurahsFragments;
import com.example.quran.Utils.Utils;

public class MainActivity extends AppCompatActivity {
    Menu optionsMenu;
    ImageView edit;
    static TextView nameReader;
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
                Intent myIntent = new Intent(MainActivity.this,SwitchLang.class);
                startActivity(myIntent);
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main, Readers_nameFragment.newInstance()).commitNow();
        }
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

