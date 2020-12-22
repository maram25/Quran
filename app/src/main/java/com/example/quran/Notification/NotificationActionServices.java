package com.example.quran.Notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public class NotificationActionServices extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.sendBroadcast(new Intent("TRACKS_TRACKS")
                .putExtra("actionname",intent.getAction()));
    }
}/*

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MusicNotificationBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent sendIntent=new Intent("TRACKS");
        sendIntent.putExtra("actionname",intent.getAction());
        LocalBroadcastManager.getInstance(context).sendBroadcast(sendIntent);

    }
}*/