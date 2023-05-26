package com.example.healthmanagerment_app.mainScreen;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.mainScreen.home.Home;
import com.example.healthmanagerment_app.mainScreen.list.list;
import com.example.healthmanagerment_app.mainScreen.notification.notification;
import com.example.healthmanagerment_app.mainScreen.info.info;
import com.example.healthmanagerment_app.mainScreen.orderDate.orderDate;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthmanagerment_app.databinding.ActivityMainScreenBinding;

public class mainScreen extends AppCompatActivity implements BottomNavigationView
        .OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;
    info firstFragment = new info();
    notification secondFragment = new notification();
    orderDate thirdFragment = new orderDate();

    Home homeFrament = new Home();

    list listFragment = new list();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.Home);
    }

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {
        if(R.id.Home==item.getItemId()){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, homeFrament)
                    .commit();
            return true;
        }

        if(R.id.list==item.getItemId()){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, listFragment)
                    .commit();
            return true;
        }

        if(R.id.info123==item.getItemId()){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, firstFragment)
                    .commit();
            return true;
        } else if(R.id.notification==item.getItemId()){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, secondFragment)
                    .commit();
            return true;
        } else if(R.id.orderDate==item.getItemId()) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, thirdFragment)
                    .commit();
            return true;
        }
        return false;
    }

}