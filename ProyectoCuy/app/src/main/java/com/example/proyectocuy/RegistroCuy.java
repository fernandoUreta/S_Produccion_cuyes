package com.example.proyectocuy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class RegistroCuy extends AppCompatActivity implements View.OnClickListener {
    TextView cantidadCuy;
    EditText madrM,madrP,padr,engM,engH,recM,recH,gaz;
    Button siguDistri;


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
        siguDistri=findViewById(R.id.btnRCsiguiente);
        siguDistri.setOnClickListener(this);

        CalcularRecorrido();

    }

    private void CalcularRecorrido(){

        madrM.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (Double.parseDouble(madrM.getText().toString())>Double.parseDouble(gaz.getText().toString())){
                        //KmInicial.setError("Debe ser menor a KM Final");
                    }
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
        });
        madrP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (Double.parseDouble(madrM.getText().toString())>Double.parseDouble(gaz.getText().toString())){
                        //KmInicial.setError("Debe ser menor a KM Final");
                    }
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
        });
        padr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (Double.parseDouble(madrM.getText().toString())>Double.parseDouble(gaz.getText().toString())){
                        //KmInicial.setError("Debe ser menor a KM Final");
                    }
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
        });
        engM.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (Double.parseDouble(madrM.getText().toString())>Double.parseDouble(gaz.getText().toString())){
                        //KmInicial.setError("Debe ser menor a KM Final");
                    }
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
        });
        engH.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (Double.parseDouble(madrM.getText().toString())>Double.parseDouble(gaz.getText().toString())){
                        //KmInicial.setError("Debe ser menor a KM Final");
                    }
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
        });
        recM.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (Double.parseDouble(madrM.getText().toString())>Double.parseDouble(gaz.getText().toString())){
                        //KmInicial.setError("Debe ser menor a KM Final");
                    }
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
        });
        recH.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (Double.parseDouble(madrM.getText().toString())>Double.parseDouble(gaz.getText().toString())){
                        //KmInicial.setError("Debe ser menor a KM Final");
                    }
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
        });
        gaz.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (Double.parseDouble(madrM.getText().toString())>Double.parseDouble(gaz.getText().toString())){
                        //KmInicial.setError("Debe ser menor a KM Final");
                    }
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
                    cantidadCuy.setText(total+"");
                }catch (Exception e){
                    cantidadCuy.setText("");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,DistribucionRecomendado.class);
        startActivity(i);
    }

}