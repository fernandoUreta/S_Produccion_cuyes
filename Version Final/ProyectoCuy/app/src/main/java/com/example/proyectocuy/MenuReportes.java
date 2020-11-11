package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuReportes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_reportes);
    }


    public void btnCuy(View v){
        Intent i = new Intent(this,ReporteCuyPoza.class);
        startActivity(i);
    }
    public void btnIngresos(View v){
        Intent i = new Intent(this,ReporteCuyPoza.class);
        startActivity(i);
    }
    public void btnSalidas(View v){
        Intent i = new Intent(this,ReporteCuyPoza.class);
        startActivity(i);
    }
    public void btnMovimiento(View v){
        Intent i = new Intent(this,ReporteCuyPoza.class);
        startActivity(i);
    }
}