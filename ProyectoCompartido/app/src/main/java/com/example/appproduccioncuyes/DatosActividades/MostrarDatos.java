package com.example.appproduccioncuyes.DatosActividades;

public class MostrarDatos {
    public static DatosActividades consultar(String lanzar){
        DatosActividades datos;
        datos=new DatosActividades();
        try {

            datos.Engorde="1";
            datos.Padrillo="1";
            datos.Empadre="1";
            datos.Recria="1";
            return datos;
        }catch (Exception e){
            return null;
        }
    }
}
