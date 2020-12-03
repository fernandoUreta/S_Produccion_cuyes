package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.example.proyectocuy.Tools.PdfGenerador;

import java.io.File;

public class MenuReportes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_reportes);
        showToolbar("REPORTES",true);

    //Permisos
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                        PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,},
                    1000);
        }
    }


    public void btnCuy(View v){
        Intent i = new Intent(this,ReporteCuyPoza.class);
        startActivity(i);
    }
    public void btnIngresosClick(View view)
    {
        File outputFile = new File(Environment.getExternalStoragePublicDirectory (Environment.DIRECTORY_DOCUMENTS), "TESIS.pdf");
        Uri uri = Uri.fromFile(outputFile);
        try {
            Intent i=new Intent("android.intent.action.MAIN");
            i.setAction(Intent.ACTION_SEND);
            i.setType("application/pdf");
            i.putExtra(Intent.EXTRA_STREAM, PdfGenerador.getRuta());
            startActivity(i);
            PdfGenerador.crearPDF_Ingreso(this);
        }catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
        }

    }
    public void btnSalidasClick(View view) {
        PdfGenerador.crearPDF_Salida(this);
    }
    public void btnMovimientoPoblacionalClick(View view)
    {
        PdfGenerador.crearPDF_MovimientoPoblacional(this);
    }

    public void showToolbar(String tittle, Boolean upButton)
    {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}