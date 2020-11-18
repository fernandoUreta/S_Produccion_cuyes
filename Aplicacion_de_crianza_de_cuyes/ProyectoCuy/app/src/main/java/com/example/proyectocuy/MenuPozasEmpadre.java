package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.proyectocuy.Adaptador.ExpPCAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuPozasEmpadre extends AppCompatActivity {
    private ExpandableListView expLV;
    private ExpPCAdapter adapter;
    private ArrayList<String> listCategoria;
    private Map<String,ArrayList<String>> mapChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pozas_empadre);
        showToolbar("Pozas de empadre",true);
        expLV=(ExpandableListView) findViewById(R.id.expLV);
        listCategoria=new ArrayList<>();
        mapChild = new HashMap<>();
        cargarDatos();
    }
    private void cargarDatos(){
        ArrayList<String> listaA1=new ArrayList<>();

        for (int i=1;i<=BD_ProduccionCuyes.consultarCantidadPozasEmpadre();i++){
            listCategoria.add("A"+i);
        }

        listaA1.add("1");
        for (int i=0;i<BD_ProduccionCuyes.consultarCantidadPozasEmpadre();i++){
            mapChild.put(listCategoria.get(i),listaA1);
        }

        adapter=new ExpPCAdapter(listCategoria, mapChild, this);
        expLV.setAdapter(adapter);
    }
    public void showToolbar(String tittle, Boolean upButton)
    {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}