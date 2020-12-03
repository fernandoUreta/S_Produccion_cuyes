package com.example.proyectocuy.Tools;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;


import com.example.proyectocuy.AccesoBD.BD_AccesoDatos;
import com.example.proyectocuy.ModeloDatos.FilaMovEntradaSalida_Reporte;
import com.example.proyectocuy.ModeloDatos.FilaMovPoblacional_reporte;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PdfGenerador {


    public static void crearPDF_Ingreso(Context context){
        Document document=new Document();
        try{
            File file=crearFichero("Ingreso cuyes.pdf");
            FileOutputStream ficheroPDF = new FileOutputStream(file.getAbsolutePath());

            PdfWriter writer = PdfWriter.getInstance(document, ficheroPDF);

            document.open();

            document.add(new Paragraph("Reporte de ingreso de cuyes"+"\n\n"));

            document.add(new Paragraph( "Se muestran ingreos a las pozas por nacimiento, adquisición o traslado de pozas\n\n"));

            PdfPTable tabla=new PdfPTable(3);

            document.add(llenarTablaIngreso_Salidas("Ingreso",tabla,context));
        }catch (DocumentException e) {
        }catch (IOException e){
        }finally {
            document.close();
        }
    }

    public static void crearPDF_Salida(Context context){
        Document document=new Document();
        try{
            File file=crearFichero("Salida cuyes.pdf");
            FileOutputStream ficheroPDF = new FileOutputStream(file.getAbsolutePath());

            PdfWriter writer = PdfWriter.getInstance(document, ficheroPDF);

            document.open();
            document.add(new Paragraph("Reporte de salida de cuyes"+"\n\n"));

            document.add(new Paragraph( "Se muestran salidas a las pozas por nacimiento, adquisición o traslado de pozas\n\n"));

            PdfPTable tabla=new PdfPTable(3);

            document.add(llenarTablaIngreso_Salidas("Salida",tabla,context));
        }catch (DocumentException e){
        }catch (IOException e){
        }finally {
            document.close();
        }
    }

    public static void crearPDF_MovimientoPoblacional(Context context){
        Document document=new Document();
        try{
            File file=crearFichero("Movimiento poblacional.pdf");
            FileOutputStream ficheroPDF = new FileOutputStream(file.getAbsolutePath());

            PdfWriter writer = PdfWriter.getInstance(document, ficheroPDF);

            document.open();

            document.add(new Paragraph("Reporte de movimiento poblacional"+"\n\n"));

            Date fechaInicio=new Date(),fechaFin=new Date();
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
            document.add(new Paragraph( "Resumen de movimiento poblacional")); //del "+dateFormat.format(fechaInicio)+"   Al   "+dateFormat.format(fechaFin)));
            document.add(new Paragraph("\n\n"));


            PdfPTable tablaI=new PdfPTable(9);
            PdfPTable tablaO=new PdfPTable(9);

            document.add(new Paragraph("Ingresos"));
            document.add(llenarTablaMov_Poblacional(tablaI,context,1));

            document.add(new Paragraph("Salidas"));
            document.add(llenarTablaMov_Poblacional(tablaO,context,2));


        }catch (DocumentException e){
        }catch (IOException e){
        }finally {
            document.close();
        }
    }

    private static PdfPTable llenarTablaMov_Poblacional(PdfPTable table, Context context,int k)
    {
        List<FilaMovPoblacional_reporte> report=new ArrayList<>();
        report.clear();
        if (k==1)
        {
            report.addAll(BD_AccesoDatos.reporteMovPoblacional(context,"Ingreso","IC","Compras"));
            report.addAll(BD_AccesoDatos.reporteMovPoblacional(context,"Ingreso","IN","Nacimientos"));
            report.addAll(BD_AccesoDatos.reporteMovPoblacional(context,"Ingreso","IR","Rotación"));
            report.addAll(BD_AccesoDatos.reporteMovPoblacional(context,"Ingreso","IO","Otros"));
        }else
            {
                report.addAll(BD_AccesoDatos.reporteMovPoblacional(context,"Salida","SC","Consumo"));
                report.addAll(BD_AccesoDatos.reporteMovPoblacional(context,"Salida","SM","Muerte natural"));
                report.addAll(BD_AccesoDatos.reporteMovPoblacional(context,"Salida","SV","Ventas"));
                report.addAll(BD_AccesoDatos.reporteMovPoblacional(context,"Salida","SR","Rotación"));
                report.addAll(BD_AccesoDatos.reporteMovPoblacional(context,"Salida","SO","Otros"));

            }
        //Set titulos Ingreso
        table.addCell("Tipo Movimiento");
        table.addCell("Lactantes Hembras");
        table.addCell("Lactantes Machos");
        table.addCell("Recría Hembra");
        table.addCell("Recría Macho");
        table.addCell("Engorde Hembra");
        table.addCell("Engorde Macho");
        table.addCell("Padrillos");
        table.addCell("Madres");
        Toast.makeText(context,"Cantidad: "+report.size(),Toast.LENGTH_LONG).show();

        int suma1=0,suma2=0,suma3=0,suma4=0,suma5=0,suma6=0,suma7=0,suma8=0;
        try {
            for (int i = 0; i<report.size(); i++){
                table.addCell(String.valueOf(report.get(i).getTipoMovimiento()));
                table.addCell(String.valueOf(report.get(i).getLc_hembras()));
                table.addCell(String.valueOf(report.get(i).getLc_machos()));
                table.addCell(String.valueOf(report.get(i).getRc_hembras()));
                table.addCell(String.valueOf(report.get(i).getRc_machos()));
                table.addCell(String.valueOf(report.get(i).getEg_hembras()));
                table.addCell(String.valueOf(report.get(i).getEg_machos()));
                table.addCell(String.valueOf(report.get(i).getPadrillos()));
                table.addCell(String.valueOf(report.get(i).getMadres()));
                suma1=suma1+report.get(i).getLc_hembras();
                suma2=suma2+report.get(i).getLc_machos();
                suma3=suma3+report.get(i).getRc_hembras();
                suma4=suma4+report.get(i).getRc_machos();
                suma5=suma5+report.get(i).getEg_hembras();
                suma6=suma6+report.get(i).getEg_machos();
                suma7=suma7+report.get(i).getPadrillos();
                suma8=suma8+report.get(i).getMadres();

            }
            table.addCell("Suma");
            table.addCell(String.valueOf(suma1));
            table.addCell(String.valueOf(suma2));
            table.addCell(String.valueOf(suma3));
            table.addCell(String.valueOf(suma4));
            table.addCell(String.valueOf(suma5));
            table.addCell(String.valueOf(suma6));
            table.addCell(String.valueOf(suma7));
            table.addCell(String.valueOf(suma8));

            return table;
        }catch (Exception e){
            Toast.makeText(context,"No funciona: "+e.toString(),Toast.LENGTH_LONG).show();
            return null;
        }
    }

    private static PdfPTable llenarTablaIngreso_Salidas(String tipo, PdfPTable table, Context context)
    {
        List<FilaMovEntradaSalida_Reporte> report;
        report= BD_AccesoDatos.reporte(tipo,context);

        //Set titulos
        table.addCell("Fecha");
        table.addCell("Motivo");
        table.addCell("Poza");
        Toast.makeText(context,"Cantidad: "+report.size(),Toast.LENGTH_LONG).show();

        try {
            for (int i = 0; i<report.size(); i++){
                table.addCell(String.valueOf(report.get(i).fecha));
                table.addCell(String.valueOf(report.get(i).razon));
                table.addCell(String.valueOf(report.get(i).idPoza));
            }
            return table;
        }catch (Exception e){
            Toast.makeText(context,"No funciona: "+e.toString(),Toast.LENGTH_LONG).show();
        }
        return table;
    }

    private static File crearFichero(String nombreFichero){
        File ruta=getRuta();
        File fichero=null;
        if(ruta!=null){
            fichero=new File(ruta, nombreFichero);
        }
        return fichero;
    }

    public static File getRuta(){
        File ruta=null;

        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            ruta=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "Reportes");

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
