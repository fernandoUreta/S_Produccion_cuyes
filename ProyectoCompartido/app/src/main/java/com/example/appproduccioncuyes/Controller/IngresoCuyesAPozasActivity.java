package com.example.appproduccioncuyes.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.appproduccioncuyes.R;

public class IngresoCuyesAPozasActivity extends AppCompatActivity {

    Spinner spTipoIngreso,spCategoria,spGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_cuyes_a_pozas);

        //Inicializado
        spTipoIngreso=(Spinner)findViewById(R.id.spTipoIngreso);
        spCategoria=(Spinner)findViewById(R.id.spCategoria);
        spGenero=(Spinner)findViewById(R.id.spGenero);

        ArrayAdapter<CharSequence> adapterTipoIngreso = ArrayAdapter.createFromResource(this, R.array.tipoIngresoCuy,R.layout.spinner_formato);
        spTipoIngreso.setAdapter(adapterTipoIngreso);

        ArrayAdapter<CharSequence> adapterCategoria = ArrayAdapter.createFromResource(this, R.array.categoriasCuy,R.layout.spinner_formato);
        spCategoria.setAdapter(adapterCategoria);

        ArrayAdapter<CharSequence> adapterGenero = ArrayAdapter.createFromResource(this, R.array.generosCuy,R.layout.spinner_formato);
        spGenero.setAdapter(adapterGenero);
    }
}