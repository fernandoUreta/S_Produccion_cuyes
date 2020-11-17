package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.proyectocuy.Adaptador.ExpPCAdapter;
import com.example.proyectocuy.Adaptador.ExpPCAdapterPad;
import com.example.proyectocuy.ModeloDatos.Poza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuPozasPadrillo extends AppCompatActivity {
    private ExpandableListView expLV;
    private ExpPCAdapterPad adapter;
    private ArrayList<String> listCategoria;
    private Map<String,ArrayList<String>> mapChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pozas_padrillo);
        expLV=(ExpandableListView) findViewById(R.id.expLV);
        listCategoria=new ArrayList<>();
        mapChild = new HashMap<>();


        cargarDatos();
        
    }

    private void cargarDatos() {
        String lista = null;
        for (int i=1;i<=BD_ProduccionCuyes.consultarCantidadPozasPadrillo();i++){
            lista="listaD"+i;
        }
        Toast.makeText(this, lista, Toast.LENGTH_SHORT).show();
        ArrayList<String> listaD1=new ArrayList<>();
        ArrayList<String> listaD2=new ArrayList<>();
        ArrayList<String> listaD3=new ArrayList<>();
        ArrayList<String> listaD4=new ArrayList<>();
        ArrayList<String> listaD5=new ArrayList<>();
        ArrayList<String> listaD6=new ArrayList<>();
        ArrayList<String> listaD7=new ArrayList<>();
        ArrayList<String> listaD8=new ArrayList<>();
        ArrayList<String> listaD9=new ArrayList<>();
        ArrayList<String> listaD10=new ArrayList<>();
        ArrayList<String> listaD11=new ArrayList<>();
        ArrayList<String> listaD12=new ArrayList<>();
        ArrayList<String> listaD13=new ArrayList<>();
        ArrayList<String> listaD14=new ArrayList<>();
        ArrayList<String> listaD15=new ArrayList<>();
        ArrayList<String> listaD16=new ArrayList<>();

        for (int i=1;i<=BD_ProduccionCuyes.consultarCantidadPozasPadrillo();i++){
            listCategoria.add("D"+i);
        }

        listaD1.add("10");
        listaD2.add("10");
        listaD3.add("10");
        listaD4.add("10");
        listaD5.add("10");
        listaD6.add("10");
        listaD7.add("10");
        listaD8.add("10");
        listaD9.add("10");
        listaD10.add("10");
        listaD11.add("10");
        listaD12.add("10");
        listaD13.add("10");
        listaD14.add("10");
        listaD15.add("10");
        listaD16.add("10");


        mapChild.put(listCategoria.get(0),listaD1);
        mapChild.put(listCategoria.get(1),listaD2);
        mapChild.put(listCategoria.get(2),listaD3);
        mapChild.put(listCategoria.get(3),listaD4);
        mapChild.put(listCategoria.get(4),listaD5);
        mapChild.put(listCategoria.get(5),listaD6);
        mapChild.put(listCategoria.get(6),listaD7);
        mapChild.put(listCategoria.get(7),listaD8);
        mapChild.put(listCategoria.get(8),listaD9);
        mapChild.put(listCategoria.get(9),listaD10);
        mapChild.put(listCategoria.get(10),listaD11);
        mapChild.put(listCategoria.get(11),listaD12);
        mapChild.put(listCategoria.get(12),listaD13);
        mapChild.put(listCategoria.get(13),listaD14);
        mapChild.put(listCategoria.get(14),listaD15);
        mapChild.put(listCategoria.get(15),listaD16);


        adapter=new ExpPCAdapterPad(listCategoria, mapChild, this);
        expLV.setAdapter(adapter);
    }
}