package com.example.proyectocuy;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class C_RegistroIngresoCuyes extends AppCompatActivity {

    EditText txtID,txtEdad;
    Spinner cmbTipoIngreso, cmbCategoria,cmbGenero;
    Button btnAgregar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ingreso_cuyes);

        //Declarado de spiner
        txtID=(EditText)findViewById(R.id.txtCodigoCuy);
        txtEdad=(EditText)findViewById(R.id.txtEdad);

        //Declarado y llenado de spiners

        cmbTipoIngreso=(Spinner)findViewById(R.id.cmbTipoIngreso);
        ArrayAdapter<CharSequence> adapterTipoIngreso = ArrayAdapter.createFromResource(this, R.array.tipoIngresoCuy, android.R.layout.simple_spinner_item);
        cmbTipoIngreso.setAdapter(adapterTipoIngreso);

        cmbCategoria=(Spinner)findViewById(R.id.cmbCategoriaCuy);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.categoriasCuy, android.R.layout.simple_spinner_item);
        cmbCategoria.setAdapter(adapter);

        cmbGenero=(Spinner)findViewById(R.id.cmbGenero);
        ArrayAdapter<CharSequence> adapterGenero = ArrayAdapter.createFromResource(this, R.array.generos, android.R.layout.simple_spinner_item);
        cmbGenero.setAdapter(adapterGenero);

        //Declarado de boton
        btnAgregar=(Button)findViewById(R.id.btnAgregar);


    }

    private void registrar()
    {

        RegistrarCuyes.registrarCuy(txtID,cm);

        //int id,String tipoCuy,String genero,int edad,String idPoza

    }
}
