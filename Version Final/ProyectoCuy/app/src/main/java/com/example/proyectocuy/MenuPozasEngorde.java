package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.proyectocuy.Adaptador.ExpPCAdapter;
import com.example.proyectocuy.Adaptador.ExpPCAdapterEngRec;
import com.example.proyectocuy.ModeloDatos.Poza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuPozasEngorde extends AppCompatActivity {
    private ExpandableListView expLV;
    private ExpPCAdapterEngRec adapter;
    private ArrayList<String> listCategoria;
    private Map<String,ArrayList<String>> mapChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pozas_engorde);

        expLV=(ExpandableListView) findViewById(R.id.expLV);
        listCategoria=new ArrayList<>();
        mapChild = new HashMap<>();


        cargarDatos();
    }

    private void cargarDatos() {
        ArrayList<String> listaMadres=new ArrayList<>();
        ArrayList<String> listaPadrillo=new ArrayList<>();
        ArrayList<String> listaGazapos=new ArrayList<>();
        ArrayList<String> listaEdad=new ArrayList<>();

        for (int i=1;i<=BD_ProduccionCuyes.consultarCantidadPozasEngorde();i++){
            listCategoria.add("B"+i);
        }

        listaMadres.add("10");

        listaPadrillo.add("10");

        listaGazapos.add("10");

        listaEdad.add("10");

        mapChild.put(listCategoria.get(0),listaMadres);
        mapChild.put(listCategoria.get(1),listaPadrillo);
        mapChild.put(listCategoria.get(2),listaGazapos);
        mapChild.put(listCategoria.get(3),listaEdad);

        adapter=new ExpPCAdapterEngRec(listCategoria,mapChild,this);
        expLV.setAdapter(adapter);
    }
}