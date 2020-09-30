package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class Prueba extends AppCompatActivity {
    EditText KmInicial,KmFinal;
    TextView KmTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        KmInicial=findViewById(R.id.KmInicial);
        KmFinal=findViewById(R.id.KmFinal);
        KmTotal=findViewById(R.id.KmTotal);

        CalcularKmRecorrido();
    }

    private void CalcularKmRecorrido() {
        KmInicial.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                try {
                    double sumaKmInicial = Double.parseDouble(KmInicial.getText().toString());
                    double sumaKmFinal = Double.parseDouble(KmFinal.getText().toString());
                    DecimalFormat formato1 = new DecimalFormat("#.##");
                    String total = formato1.format(sumaKmFinal + sumaKmInicial);
                    KmTotal.setText(total + "");
                } catch (Exception e) {
                    KmTotal.setText("");
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    double sumaKmInicial = Double.parseDouble(KmInicial.getText().toString());
                    double sumaKmFinal = Double.parseDouble(KmFinal.getText().toString());
                    DecimalFormat formato1 = new DecimalFormat("#.##");
                    String total=formato1.format(sumaKmFinal+sumaKmInicial);
                    KmTotal.setText(total+"");
                }catch (Exception e){
                    KmTotal.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (Double.parseDouble(KmInicial.getText().toString())>Double.parseDouble(KmFinal.getText().toString())){
                        //KmInicial.setError("Debe ser menor a KM Final");
                    }
                    double sumaKmInicial = Double.parseDouble(KmInicial.getText().toString());
                    double sumaKmFinal = Double.parseDouble(KmFinal.getText().toString());
                    DecimalFormat formato1 = new DecimalFormat("#.##");
                    String total=formato1.format(sumaKmFinal+sumaKmInicial);
                    KmTotal.setText(total+"");
                }catch (Exception e){
                    KmTotal.setText("");
                }
            }
        });

        KmFinal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                try {
                    double sumaKmInicial = Double.parseDouble(KmInicial.getText().toString());
                    double sumaKmFinal = Double.parseDouble(KmFinal.getText().toString());
                    DecimalFormat formato1 = new DecimalFormat("#.##");
                    String total=formato1.format(sumaKmFinal+sumaKmInicial);
                    KmTotal.setText(total+"");
                }catch (Exception e){
                    KmTotal.setText("");
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {


                    double sumaKmInicial = Double.parseDouble(KmInicial.getText().toString());
                    double sumaKmFinal = Double.parseDouble(KmFinal.getText().toString());
                    DecimalFormat formato1 = new DecimalFormat("#.##");
                    String total=formato1.format(sumaKmFinal+sumaKmInicial);
                    KmTotal.setText(total+"");
                }catch (Exception e){
                    KmTotal.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                  /*     if (Double.parseDouble(KmFinal.getText().toString())<Double.parseDouble(KmInicial.getText().toString())){
                        KmFinal.setError("Debe ser Mayor a KM Final");
                    }*/
                    double sumaKmInicial = Double.parseDouble(KmInicial.getText().toString());
                    double sumaKmFinal = Double.parseDouble(KmFinal.getText().toString());
                    DecimalFormat formato1 = new DecimalFormat("#.##");
                    String total=formato1.format(sumaKmFinal+sumaKmInicial);
                    KmTotal.setText(total+"");
                }catch (Exception e){
                    KmTotal.setText("");
                }

            }
        });
    }
}