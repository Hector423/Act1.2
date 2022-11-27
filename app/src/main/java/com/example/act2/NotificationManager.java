package com.example.act2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;

public class NotificationManager extends ContextWrapper
{
    private android.app.NotificationManager notificationManager;

    public static final String CHANNEL_SOMETHING_ID = "com.example.act2.SOMETHING";
    public static final String CHANNEL_SOMETHING_NAME = "Canal per el número de incidencies";
    public static final String CHANNEL_NOTHING_ID = "com.example.act2.NOTHING";
    public static final String CHANNEL_NOTHING_NAME = "Canal per quan no hi hagin incidencies";

    public NotificationManager(Context base)
    {
        super(base);

        //CREATE CHANNEL

        /*
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ONE_ID,
                CHANNEL_ONE_NAME, notifManager.IMPORTANCE_HIGH);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.RED);
        notificationChannel.setShowBadge(true);
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        getManager().createNotificationChannel(notificationChannel);
         */
        NotificationChannel notificationChannelSomething = new NotificationChannel
        (
            CHANNEL_SOMETHING_ID,
            CHANNEL_SOMETHING_NAME,
            notificationManager.IMPORTANCE_DEFAULT
        );
        notificationChannelSomething.enableLights(true);
        notificationChannelSomething.setLightColor(Color.YELLOW);
        notificationChannelSomething.setShowBadge(true);
        notificationChannelSomething.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        getManager().createNotificationChannel(notificationChannelSomething);

        NotificationChannel notificationChannelNothing = new NotificationChannel
        (
            CHANNEL_NOTHING_ID,
            CHANNEL_NOTHING_NAME,
            notificationManager.IMPORTANCE_DEFAULT
        );
        notificationChannelNothing.enableLights(true);
        notificationChannelNothing.setLightColor(Color.GREEN);
        notificationChannelNothing.setShowBadge(true);
        notificationChannelNothing.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        getManager().createNotificationChannel(notificationChannelNothing);
    }

    private android.app.NotificationManager getManager()
    {
        if(notificationManager==null)
        {
            notificationManager = (android.app.NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return notificationManager;
    }

    public void notify(int id, Notification.Builder notificationBuilder)
    {
        getManager().notify(id, notificationBuilder.build());
    }

    public Notification.Builder getNotificationSomething(String title, String body)
    {
        return new Notification.Builder(getApplicationContext(), CHANNEL_SOMETHING_ID)
                .setContentTitle(title)
                .setContentText(body)
//                .setSmallIcon(R.drawable.ic_warning)
                .setAutoCancel(true);
    }

    public Notification.Builder getNotificationNothing(String title, String body)
    {
        return new Notification.Builder(getApplicationContext(), CHANNEL_NOTHING_ID)
                .setContentTitle(title)
                .setContentText(body)
//                .setSmallIcon(R.drawable.ic_warning)
                .setAutoCancel(true);
    }
}