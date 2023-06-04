package com.example.healthmanagerment_app.mainScreen;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.healthmanagerment_app.Notifi;
import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.api.API;
import com.example.healthmanagerment_app.api.RetrofitClient;
import com.example.healthmanagerment_app.donthuoc.viewThuoc;
import com.example.healthmanagerment_app.mainScreen.home.Home;
import com.example.healthmanagerment_app.mainScreen.list.list;
import com.example.healthmanagerment_app.mainScreen.Notification.notification;
import com.example.healthmanagerment_app.mainScreen.info.info;
import com.example.healthmanagerment_app.mainScreen.orderDate.orderDate;
import com.example.healthmanagerment_app.mainScreen.orderDate.registration.registration;
import com.example.healthmanagerment_app.model.ResponeNotification;
import com.example.healthmanagerment_app.model.ResponePrescription;
import com.example.healthmanagerment_app.model.RpCalender;
import com.example.healthmanagerment_app.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mainScreen extends AppCompatActivity implements BottomNavigationView
        .OnNavigationItemSelectedListener {

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

        Bundle extras = getIntent().getExtras();

        String id = extras.getString("acc");

        Bundle bundle = new Bundle();
        bundle.putString("data", id);
        firstFragment.setArguments(bundle);
        secondFragment.setArguments(bundle);
        thirdFragment.setArguments(bundle);
        homeFrament.setArguments(bundle);
        listFragment.setArguments(bundle);
        Log.v("acc",id);
        User user = new User();
        user.setAccount(id);
        API methods = RetrofitClient.getRetrofit().create(API.class);
        Call<ResponePrescription> call = methods.getListPrescription(user);
        call.enqueue(new Callback<ResponePrescription>() {
            @Override
            public void onResponse(Call<ResponePrescription> call, Response<ResponePrescription> response) {
                ResponePrescription data = response.body();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                for (ResponePrescription.Prescription dt:data.data
                ) {
                    notifi2(dt.idPres,dt.namePres);
                }
            }

            @Override
            public void onFailure(Call<ResponePrescription> call, Throwable t) {

            }
        });
        API methods1 = RetrofitClient.getRetrofit().create(API.class);
        Call<RpCalender> call1 = methods1.getListPrescriptionNoti(user);
        call1.enqueue(new Callback<RpCalender>() {
            @Override
            public void onResponse(Call<RpCalender> call, Response<RpCalender> response) {
                RpCalender data = response.body();
                for (RpCalender.Calender dt:data.data
                ) {
                    notifi(dt.putDate,dt.faculty);
                }
            }
            @Override
            public void onFailure(Call<RpCalender> call, Throwable t) {
            }
        });

        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.Home);

    }

    private void notifi(String date,String fal){
        int requestID = (int) System.currentTimeMillis();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        Intent intent = new Intent(this, registration.class);
        intent.putExtra("spinner",fal);
        intent.putExtra("dateTime",date);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestID, intent, PendingIntent.FLAG_IMMUTABLE);
        Notification notification = new NotificationCompat.Builder(this, Notifi.CHANNEL_ID)
                .setContentTitle("Thong bao kham benh")
                .setContentText("Lich Kham Benh Ngay: "+date)
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setLargeIcon(bitmap)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if(manager !=null){
            manager.notify(getNotificationID(),notification);
        }
    }
    private void notifi2(String idPres,String name){
        int requestID = (int) System.currentTimeMillis();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        Intent intent1 = new Intent(this, viewThuoc.class);
        Log.v("fff456","1");
        intent1.putExtra("idPres",idPres);
//        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestID, intent1, PendingIntent.FLAG_IMMUTABLE);
        Notification notification = new NotificationCompat.Builder(this, Notifi.CHANNEL_ID)
                .setContentTitle("Nhac nho uong thuoc")
                .setContentText("Benh: "+name)
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setLargeIcon(bitmap)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if(manager !=null){
            manager.notify(getNotificationID(),notification);
        }
    }

    private int getNotificationID() {
        return (int) new Date().getTime();
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