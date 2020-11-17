package com.example.proyectocuy.Controller;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.proyectocuy.AccesoBD.BD_AccesoDatos;
import com.example.proyectocuy.R;


public class Eliminar_PozasActivity extends AppCompatActivity {

    EditText etIdPoza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar__pozas);
        showToolbar("Eliminar Pozas",true);
        etIdPoza =(EditText)findViewById(R.id.etIdPoza);
    }

    public void btnEliminarClick(View view)
    {
        BD_AccesoDatos.eliminarPoza(etIdPoza.getText().toString(),this);
        etIdPoza.setText("");
    }
    public void showToolbar(String tittle, Boolean upButton)
    {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}