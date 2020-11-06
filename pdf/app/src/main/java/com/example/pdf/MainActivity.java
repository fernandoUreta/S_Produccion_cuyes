package com.example.pdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pdf.AccesoBD.BD_AccesoDatos;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String Nombre_Directorio="ReportesPDFs";
    String Nombre_Documento="ReporteIngreso";

    TextView txtReporte;
    Button btnIngreso;
    Button btnSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIngreso=findViewById(R.id.btnIngreso);
        btnSalida=findViewById(R.id.btnSalida);
        //Permisos
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED &&
        ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
        PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,},
                    1000);
        }
        //Generar el PDF Ingresos
        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearPDF();
                Toast.makeText(MainActivity.this,"Se creo el PDF", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void crearPDF(){
        Document document=new Document();
        try{
            File file=crearFichero(Nombre_Documento);
            FileOutputStream ficheroPDF = new FileOutputStream(file.getAbsolutePath());

            PdfWriter writer = PdfWriter.getInstance(document, ficheroPDF);

            document.open();

            document.add(new Paragraph("REPORTE DE INGRESOS\n\n"));
            document.add(new Paragraph( "Se muestran los ingresos a las pozas por nacimiento, adquisición o traslado de pozas\n\n"));

            // Insertamos una tabla
            PdfPTable tabla=new PdfPTable(3);
            /*for (int i = 0; i<30 ; i++){
                tabla.addCell("CELDA"+i);
            }*/
            document.add(llenarTabla(tabla,"Ingreso"));
        }catch (DocumentException e){
        }catch (IOException e){
        }finally {
            document.close();
        }
    }

    public PdfPTable llenarTabla(PdfPTable table,String tipo)
    {
        List<FilaReporte> report;
        report=BD_AccesoDatos.reporte(tipo,getApplicationContext());

        //Set titulos
        table.addCell("Fecha");
        table.addCell("Motivo");
        table.addCell("Poza");

        for (int i = 1; i<report.size() ; i++){
            table.addCell(report.get(i).fecha);
            table.addCell(report.get(i).razon);
            table.addCell(report.get(i).idPoza);
        }
        return table;
    }



    public File crearFichero(String nombreFichero){
        File ruta=getRuta();

        File fichero=null;
        if(ruta!=null){
            fichero=new File(ruta, nombreFichero);
        }
        return fichero;
    }
    public File getRuta(){
        File ruta=null;

        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            ruta=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), Nombre_Directorio);

            if(ruta!=null){
                if(!ruta.mkdirs()){
                    if(!ruta.exists()){
                        return null;
                    }
                }
            }
        }
        return ruta;
    }
}