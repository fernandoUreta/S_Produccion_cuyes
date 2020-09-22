package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
Animation animacion;
TextView bienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bienvenido=findViewById(R.id.txtBienvenido);
        animacion= AnimationUtils.loadAnimation(this,R.anim.animacionprincipal);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sonidocuyes);
        mediaPlayer.start();
        bienvenido.startAnimation(animacion);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i= new Intent(Splash.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        },4000);
    }

}