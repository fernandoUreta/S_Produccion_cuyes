package com.example.proyectocuy;


import com.example.proyectocuy.ModeloDatos.Cuy;

import java.util.Calendar;
import java.util.Date;

public class RegistrarCuyes {


    public static void registrarCuy(int id,String tipoCuy,String genero,int edad,String idPoza)
    {
        Cuy cuy=new Cuy();
        Calendar fechaHoy = Calendar.getInstance();
        fechaHoy.add(Calendar.DAY_OF_YEAR,-edad);

        switch (tipoCuy)
        {
            case "Gazapos":cuy.categoria="1";break;
            case "Recria":cuy.categoria="2";break;
            case "Engorde":cuy.categoria="3";break;
            case "Primeriza":cuy.categoria="4";break;
            case "Madre adulta":cuy.categoria="5";break;
            case "Padrillo":cuy.categoria="6";break;
        }
        cuy.genero=genero;
        cuy.idPoza=idPoza;
        cuy.fechaNaci=convert(fechaHoy.getTime());
        cuy.cuyId=String.valueOf(id);
        BD_ProduccionCuyes.registrarCuy(cuy);

    }
    //Convertir javaDate to SqlDate
    private static java.sql.Date convert(Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }


}
