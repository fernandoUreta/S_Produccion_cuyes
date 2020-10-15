package com.example.appcuyes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner tiposPozas;
    EditText txtAncho,txtLargo,txtCantidad,txtCantidadPozasCreadas;
    Button btnRegistrar,btnMasInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_pozas);

    }
}