package com.example.quran;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.example.quran.Utils.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class SwitchLang extends AppCompatActivity {
    Button EnLang,ArLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_lang);
        EnLang=findViewById(R.id.enLang);
        ArLang=findViewById(R.id.arLang);

    /*  SharedPreferences sp1 = getSharedPreferences("Login", MODE_PRIVATE);
        String Lang = sp1.getString("Lang", null);
        if (Lang != null) {SetAppLocale(Lang); }
        Log.e("fcm", FirebaseInstanceId.getInstance().getToken()+" ll");*/
        EnLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetAppLocale("en");
                EnLang.setBackgroundColor(Color.parseColor("#06651C"));
               /* Fragment fragment = null;
                fragment = new FragmentLogin();
                replaceFragment(fragment);*/

            }
        });
        ArLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetAppLocale("ar");
                ArLang.setBackgroundColor(Color.parseColor("#06651C"));
                /*Fragment fragment = null;
                fragment = new FragmentLogin();
                replaceFragment(fragment);*/

            }
        });


    }

    public SharedPreferences sp;
    public  SharedPreferences.Editor Ed;
    private void SetAppLocale(String localeCode) {
        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration conf = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            conf.setLocale(new Locale(localeCode));
        } else {
            conf.locale = new Locale(localeCode);
        }
        sp=getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences sp1=getSharedPreferences("Login", MODE_PRIVATE);
        Ed = sp.edit();
        Ed.putString("Lang", localeCode);
        Ed.commit();

        resources.updateConfiguration(conf, dm);
        Utils.Lang = localeCode;
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }


}
