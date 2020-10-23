package com.example.proyectocuy;


import com.example.proyectocuy.ModeloDatos.Cuy;
import com.example.proyectocuy.Recursos_Adicionales.Fechas;

import java.util.Calendar;
import java.util.Date;

public class RegistrarCuyes {


    public static void registrarCuy(int id,String tipoCuy,String genero,int edad,String idPoza)
    {
        Cuy cuy=new Cuy();
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
        cuy.fechaNaci= Fechas.calcularFechaNacimiento(edad);
        cuy.cuyId=String.valueOf(id);
        BD_ProduccionCuyes.registrarCuy(cuy);
    }





}
