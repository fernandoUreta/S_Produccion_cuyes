package com.example.proyectocuy.Tools;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.BackoffPolicy;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;


import com.example.proyectocuy.Calendario;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WorkManagerNotificacion extends Worker {

    public WorkManagerNotificacion(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }


    public static void guardarNotificacion(Data data, String tag, Context context)
    {

        /*Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .build();*/
        WorkRequest myUploadWork =
                new OneTimeWorkRequest.Builder(WorkManagerNotificacion.class)
                        .setInitialDelay(0,TimeUnit.MILLISECONDS)
                        .addTag(tag)
                        .setInputData(data)
                        .setBackoffCriteria(BackoffPolicy.LINEAR,
                                OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                                TimeUnit.MILLISECONDS)
                        //.setConstraints(constraints)
                        .build();
        WorkManager ins= WorkManager.getInstance(context);
        ins.enqueue(myUploadWork);

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
        return Result.retry();
    }

    private int cantidadActividades()
    {
        AdministradorActividades admActividades=new AdministradorActividades(getApplicationContext());
        return admActividades.getActividadesAll().size();
    }

}