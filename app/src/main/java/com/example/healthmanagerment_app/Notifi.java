package com.example.healthmanagerment_app;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.util.Log;

public class Notifi extends Application {
    public static final String CHANNEL_ID="01";

    @Override
    public void onCreate() {
        super.onCreate();
        notifi();
    }
    private void notifi() {
        Log.v("abcdaaaaa", "akjsgdkagsdkagdshagdsjasd");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }
}
