package com.example.appproduccioncuyes.Recursos_Adicionales;

import java.util.Calendar;
import java.util.Date;

public class Fechas {

    static Calendar fechaHoy = Calendar.getInstance();

    public static java.sql.Date calcularFechaNacimiento(int edad)
    {

        fechaHoy.add(Calendar.DAY_OF_YEAR,-edad);
        java.sql.Date fechaNacimiento =convert(fechaHoy.getTime());
        return fechaNacimiento;
    }
    public static int calcularEdad(Date fechaNacimiento)
    {
        int edad;
        Calendar fechaNaci = Calendar.getInstance();
        fechaNaci.setTime(fechaNacimiento);
        edad=(fechaHoy.DAY_OF_YEAR)-(fechaNaci.DAY_OF_YEAR);
        return edad;

    }
    public static java.sql.Date mostrarFechaHoy()
    {
        java.sql.Date fechaHoySQL=convert(fechaHoy.getTime());
        return  fechaHoySQL;
    }
    private static java.sql.Date convert(Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
