package com.example.quran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.quran.Readers_name.Readers_nameFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //setting the title
        toolbar.setTitle("مشاري راشد");
        if (savedInstanceState == null) {
           getSupportFragmentManager().beginTransaction()
                   .replace(R.id.main, Readers_nameFragment.newInstance()).commitNow();

          /*  Fragment mFragment = null;
            mFragment = new Readers_NameFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, Readers_NameFragment.newInstance()).commit();*/

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.bar, menu);
        MenuItem editItem = menu.findItem(R.id.menuEdit);
        Intent intent = null;
    /*    switch (item.getItemId()) {
            case R.id.menuEdit:
                intent = new Intent(this, SwitchLang.class);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        startActivity(intent);*/

        return true;
    }

}