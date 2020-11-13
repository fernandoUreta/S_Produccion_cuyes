package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

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
        expLV=(ExpandableListView) findViewById(R.id.expLV);
        listCategoria=new ArrayList<>();
        mapChild = new HashMap<>();
        cargarDatos();
    }
    private void cargarDatos(){
        ArrayList<String> listaA1=new ArrayList<>();
        ArrayList<String> listaA2=new ArrayList<>();
        ArrayList<String> listaA3=new ArrayList<>();
        ArrayList<String> listaA4=new ArrayList<>();

        for (int i=1;i<=BD_ProduccionCuyes.consultarCantidadPozasEmpadre();i++){
            listCategoria.add("A"+i);
        }

        listaA1.add("1");
        listaA2.add("2");
        listaA3.add("3");
        listaA4.add("4");

        mapChild.put(listCategoria.get(0),listaA1);
        mapChild.put(listCategoria.get(1),listaA2);
        mapChild.put(listCategoria.get(2),listaA3);
        mapChild.put(listCategoria.get(3),listaA4);

        adapter=new ExpPCAdapter(listCategoria, mapChild, this);
        expLV.setAdapter(adapter);
    }
}