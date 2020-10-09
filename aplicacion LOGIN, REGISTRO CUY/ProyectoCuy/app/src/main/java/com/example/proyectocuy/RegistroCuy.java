package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class RegistroCuy extends AppCompatActivity implements View.OnClickListener {
    TextView cantidadCuy;
    EditText madrM,madrP,padr,engM,engH,recM,recH,gaz;
    Button siguDistri;
    int empradre,engorde,recria,PePadrillo;
    int cantidadMMempa,cantidadMPempa,cantidadPengordeM,cantidadPengordeH,cantRecH,cantRecM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cuy);
        madrM=findViewById(R.id.edtRMadrMad);
        madrP=findViewById(R.id.edtRMadrPr);
        padr=findViewById(R.id.edtRPadri);
        engM=findViewById(R.id.edtREngMach);
        engH=findViewById(R.id.edtREngHem);
        recM=findViewById(R.id.edtRRecrMach);
        recH=findViewById(R.id.edtRRecrHem);
        gaz=findViewById(R.id.edtRGazap);
        cantidadCuy=findViewById(R.id.txtCantidadCuy);
        CalcularRecorrido();
        siguDistri=findViewById(R.id.btnRCsiguiente);
        siguDistri.setOnClickListener(this);

    }

    private void CalcularRecorrido(){
        madrM.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
               sumar();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sumar();
            }
            @Override
            public void afterTextChanged(Editable s) {
                sumar();
            }
        });
        madrP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                sumar();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sumar();
            }
            @Override
            public void afterTextChanged(Editable s) {
                sumar();
            }
        });
        padr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                sumar();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sumar();
            }
            @Override
            public void afterTextChanged(Editable s) {
                sumar();
            }
        });
        engM.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                sumar();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sumar();
            }
            @Override
            public void afterTextChanged(Editable s) {
                sumar();
            }
        });
        engH.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                sumar();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sumar();
            }
            @Override
            public void afterTextChanged(Editable s) {
                sumar();
            }
        });
        recM.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                sumar();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sumar();
            }
            @Override
            public void afterTextChanged(Editable s) {
                sumar();
            }
        });
        recH.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                sumar();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sumar();
            }
            @Override
            public void afterTextChanged(Editable s) {
                sumar();
            }
        });
        gaz.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                sumar();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sumar();
            }
            @Override
            public void afterTextChanged(Editable s) {
                sumar();
            }
        });
    }

    public  void sumar(){
        try {
                    double valor1 = Double.parseDouble(madrM.getText().toString());
                    double valor2 = Double.parseDouble(madrP.getText().toString());
                    double valor3 = Double.parseDouble(padr.getText().toString());
                    double valor4 = Double.parseDouble(engM.getText().toString());
                    double valor5 = Double.parseDouble(engH.getText().toString());
                    double valor6 = Double.parseDouble(recM.getText().toString());
                    double valor7 = Double.parseDouble(recH.getText().toString());
                    double valor8 = Double.parseDouble(gaz.getText().toString());
                    DecimalFormat formato1 = new DecimalFormat("#.#");
                    String total=formato1.format(valor1+valor2+valor3+valor4+valor5+valor6+valor7+valor8);
                    cantidadCuy.setText(total + "");
                }catch (Exception e){
                    cantidadCuy.setText("");
        }
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,DistribucionRecomendado.class);
        String madreM=madrM.getText().toString();
        i.putExtra("Enviando",madreM);
        String madreP=madrP.getText().toString();
        i.putExtra("madreP",madreP);
        String padri=padr.getText().toString();
        i.putExtra("padrillo",padri);
        String engordeMac=engM.getText().toString();
        i.putExtra("engordeMacho",engordeMac);
        String engordeHem=engH.getText().toString();
        i.putExtra("engordeHembra",engordeHem);
        String recriaMacho=recM.getText().toString();
        i.putExtra("recriaMacho",recriaMacho);
        String recriaHembra=recH.getText().toString();
        i.putExtra("recriaHembra",recriaHembra);
        String gazapos=gaz.getText().toString();
        i.putExtra("gazapos",gazapos);
        startActivity(i);
    }
    /*
    public void Distribucion(){
        int valor1= Integer.parseInt(madrM.getText().toString());
        int valor2= Integer.parseInt(madrP.getText().toString());
        int valor3= Integer.parseInt(padr.getText().toString());
        int valor4= Integer.parseInt(engM.getText().toString());
        int valor5= Integer.parseInt(engH.getText().toString());
        int valor6= Integer.parseInt(recM.getText().toString());
        int valor7= Integer.parseInt(recH.getText().toString());
        int Total;
        //Cantidad de pozas para empadre 2
        cantidadMMempa=valor1/10;
        cantidadMPempa=valor2/10;
        empradre=cantidadMMempa+cantidadMPempa;

        //Cantidad de pozas para Padrillo 8
        PePadrillo=valor3-empradre;

        //cantidad de pozas para engorde 2
        cantidadPengordeM=valor4/10;
        cantidadPengordeH=valor5/10;
        engorde=cantidadPengordeM+cantidadPengordeH;

        //Cantidad de pozas para recria
        cantRecH = valor6/10;
        cantRecM=valor7/10;
        recria=cantRecH+cantRecM;

        Total=empradre+PePadrillo+engorde+recria;
    }*/
}