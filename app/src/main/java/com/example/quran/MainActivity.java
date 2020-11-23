package com.example.quran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quran.Readers_name.Readers_nameFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
           getSupportFragmentManager().beginTransaction()
                   .replace(R.id.main, Readers_nameFragment.newInstance()).commitNow();

          /*  Fragment mFragment = null;
            mFragment = new Readers_NameFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, Readers_NameFragment.newInstance()).commit();*/

        }

    }

}