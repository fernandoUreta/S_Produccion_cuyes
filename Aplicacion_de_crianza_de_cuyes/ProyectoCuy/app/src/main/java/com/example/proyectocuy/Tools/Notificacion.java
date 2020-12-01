package com.example.proyectocuy.Tools;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.proyectocuy.R;


public class Notificacion {

    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID="NOTIFICACION";
    private final static int NOTIFICATION_ID=0;

    Context context;
    String titulo;
    String contenido;
    Class destino;


    public Notificacion(Context context, String titulo, String contenido, Class destino) {
        this.context = context;
        this.titulo = titulo;
        this.contenido = contenido;
        this.destino=destino;
    }


    public  void mostrar_notificacion()
    {
        setPendingIntent();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            CharSequence name="Notificacion";
            NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID,name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        createNotification();

    }
    private void setPendingIntent()
    {
        Intent intent=new Intent(context,destino);
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(context);
        stackBuilder.addParentStack(destino);
        stackBuilder.addNextIntent(intent);
        pendingIntent=stackBuilder.getPendingIntent(1,PendingIntent.FLAG_UPDATE_CURRENT);
    }
    private void createNotification()
    {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_baseline_pets_24);
        builder.setContentTitle(titulo);
        builder.setContentText(contenido);
        builder.setColor(Color.YELLOW);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.setLights(Color.MAGENTA,1000,1000);
        builder.setVibrate(new long[]{1000,1000});
        builder.setDefaults(Notification.DEFAULT_SOUND);

        builder.setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManagerCompat= NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());
    }

    
}
