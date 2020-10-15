package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DistribucionRecomendado extends AppCompatActivity {

    int valor1, valor2, valor3, valor4, valor5, valor6, valor7, Total;
    int empradre, engorde, recria, PePadrillo;
    int cantidadPengordeM, cantidadPengordeH, cantRecH, cantRecM;

    TextView totalpozas,pozEmpadre,pozPadrillo,pozEngorde,pozRecria;
    Button btnManual,btnSiguienteR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distribucion_recomendado);

        pozEmpadre=findViewById(R.id.txtDRpozEmpadre);
        pozPadrillo=findViewById(R.id.txtDRpozPadrillo);
        pozEngorde=findViewById(R.id.txtDRpozEngorde);
        pozRecria=findViewById(R.id.txtDRpozRecria);
        totalpozas = findViewById(R.id.txtDRcantidadpozas);
        btnManual=findViewById(R.id.btnDRmanual);
        btnSiguienteR=findViewById(R.id.btnDRsiguiente);

        String mMadura = getIntent().getStringExtra("Enviando");
        Log.d("hola", mMadura);
        valor1 = Integer.parseInt(mMadura);
        String mPrimerisa = getIntent().getStringExtra("Enviando");
        Log.d("hola", mPrimerisa);
        valor2=Integer.parseInt(mPrimerisa);
        empradre=(valor1/10)+(valor2/10);

        String Padrillo = getIntent().getStringExtra("Enviando");
        Log.d("hola", Padrillo);
        valor3=Integer.parseInt(Padrillo);
        PePadrillo=valor3-empradre;

        String engMacho = getIntent().getStringExtra("Enviando");
        Log.d("hola", engMacho);
        valor4=Integer.parseInt(engMacho);
        String engHembra = getIntent().getStringExtra("Enviando");
        Log.d("hola", engHembra);
        valor5=Integer.parseInt(engHembra);
        cantidadPengordeM=valor4/10;
        cantidadPengordeH=valor5/10;
        engorde=cantidadPengordeM+cantidadPengordeH;

        String recMacho = getIntent().getStringExtra("Enviando");
        Log.d("hola", recMacho);
        valor6=Integer.parseInt(recMacho);
        String recHembra = getIntent().getStringExtra("Enviando");
        Log.d("hola", recHembra);
        valor7=Integer.parseInt(recHembra);
        cantRecH=valor6/10;
        cantRecM=valor7/10;
        recria=cantRecH+cantRecM;

        Total=empradre+PePadrillo+engorde+recria;

        pozEmpadre.setText(String.valueOf(empradre));
        pozPadrillo.setText(String.valueOf(PePadrillo));
        pozEngorde.setText(String.valueOf(engorde));
        pozRecria.setText(String.valueOf(recria));
        totalpozas.setText(String.valueOf(Total));

    /*public void Distribucion(){

        //Cantidad de pozas para empadre 2
        cantidadMMempa=mMadura/10;
        cantidadMPempa=mPrimerisa/10;
        empradre=cantidadMMempa+cantidadMPempa;

        //Cantidad de pozas para Padrillo 8
        PePadrillo=Padrillo-empradre;

        //cantidad de pozas para engorde 2
        cantidadPengordeM=engMacho/10;
        cantidadPengordeH=engHembra/10;
        engorde=cantidadPengordeM+cantidadPengordeH;

        //Cantidad de pozas para recria
        cantRecH = recHembra/10;
        cantRecM=recMacho/10;
        recria=cantRecH+cantRecM;

        Total=empradre+PePadrillo+engorde+recria;
    }*/
    }
}