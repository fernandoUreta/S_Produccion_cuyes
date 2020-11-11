package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.proyectocuy.Adaptador.TemplatePDF;

import java.util.ArrayList;

public class ReporteCuyPoza extends AppCompatActivity {
    private String[]header={"ID","Nombre","Apellido"};
    private String shortText="Hola";
    private String longText="Tenemos que aprobar el curso de Taller de proyectos si o si";
    private TemplatePDF templatePDF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_cuy_poza);
        templatePDF=new TemplatePDF(getApplicationContext());
        templatePDF.openDocument();
        templatePDF.addMetaData("Clientes","Ventas","Cañari");
        templatePDF.addTitles("Tienda EvNatural","Clientes","06/11/2020");
        templatePDF.addParagraph(shortText);
        templatePDF.addParagraph(longText);
        templatePDF.createTable(header,getClients());
        templatePDF.closeDocument();
    }

    public void pdfView(View view){
        templatePDF.viewPDF();
    }
    public void pdfApp(View view){
        templatePDF.appViewPDF(this);
    }
    private ArrayList<String[]>getClients(){
        ArrayList<String[]>rows=new ArrayList<>();
        rows.add(new String[]{"1","Pedro","Lopez"});
        rows.add(new String[]{"2","Juan","Gomez"});
        rows.add(new String[]{"3","Luis","Quisque"});
        rows.add(new String[]{"4","Pepe","Mamani"});
        rows.add(new String[]{"5","Jhon","Alarcon"});
        rows.add(new String[]{"6","Fernando","Ureta"});
        return rows;
    }
}