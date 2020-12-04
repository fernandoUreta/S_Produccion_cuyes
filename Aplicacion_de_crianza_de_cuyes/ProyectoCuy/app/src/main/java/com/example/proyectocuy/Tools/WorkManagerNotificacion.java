package com.example.proyectocuy.Tools;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.BackoffPolicy;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;


import com.example.proyectocuy.Calendario;
import com.example.proyectocuy.MenuPrincipal;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.HOURS;

public class WorkManagerNotificacion extends Worker {

    public WorkManagerNotificacion(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }


    public static void guardarNotificacion(Data data, String tag,Context context)
    {
        Calendar currentDate=Calendar.getInstance();
        Calendar dueDate=Calendar.getInstance();

        //Notificaciones a las 8am
        dueDate.set (Calendar.HOUR_OF_DAY, 8);
        dueDate.set (Calendar.MINUTE, 0);
        dueDate.set (Calendar.SECOND, 0);

        if (dueDate.before (currentDate)) {
            dueDate.add (Calendar.HOUR_OF_DAY, 24);
        }
        long timeDiff = dueDate.getTimeInMillis() - currentDate.getTimeInMillis();


        WorkRequest myNotificacionWork =
                new OneTimeWorkRequest.Builder(WorkManagerNotificacion.class)
                        .setInitialDelay(timeDiff,TimeUnit.MILLISECONDS)
                        .addTag(tag)
                        .setInputData(data)
                        .build();
        WorkManager ins= WorkManager.getInstance(context);
        ins.enqueue(myNotificacionWork);

    }

    @NonNull
    @Override
    public Result doWork() {
        String titulo=getInputData().getString("titulo");
        String mensaje=getInputData().getString("mensaje");
        Notificacion notificacion=new Notificacion(getApplicationContext(),
                titulo,
                mensaje,
                Calendario.class);
        if(cantidadActividades()>0){
            notificacion.mostrar_notificacion();
        }
        String tag="kn95";
        Data data=new Data.Builder().putString("titulo","Actividades").
                putString("mensaje","Hay actividades para hoy, toque aquí para verlas").build();
        WorkManagerNotificacion.guardarNotificacion(data,tag,getApplicationContext());
        return Result.success();
    }

    private int cantidadActividades()
    {
        AdministradorActividades admActividades=new AdministradorActividades(getApplicationContext());
        return admActividades.getActividadesAll().size();
    }

}