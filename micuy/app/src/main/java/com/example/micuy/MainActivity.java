package com.example.micuy;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.itextpdf.text.pdf.PdfTemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[]header={"Fecha","Motivo","Poza, Cantidad"};
    private String shortText="Nota";
    private String longText="**Se muestra el ingreso de nuevos cuyes y de igualmanera el ingreso por cambio de pozas";
    private ReportePDF reportePDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReportePDF reportePDF= new ReportePDF(getApplicationContext());
        reportePDF.openDocument();
        reportePDF.addMetadata("Reporte","Ingreso", "Usuario");
        reportePDF.addTitles("REPORTE DE INGRESO", "Usuario", "5/11/2020");
        reportePDF.addParagraph(shortText);
        reportePDF.addParagraph(longText);
        reportePDF.createTable(header,getClients());
        reportePDF.closeDocument();
    }
    public void pdfView(View view){
        reportePDF.viewPDF();
    }
    private ArrayList<String[]>getClients(){
        ArrayList<String []>rows=new ArrayList<>();
        rows.add(new String[]{"3/11/2020","Nacimiento","A2","12"});
        rows.add(new String[]{"4/11/2020","Adquisición","C1","10"});
        rows.add(new String[]{"4/11/2020","Nacimiento","A1","4"});
        rows.add(new String[]{"4/11/2020","Nacimiento","A3","1"});
        return rows;
    }
}