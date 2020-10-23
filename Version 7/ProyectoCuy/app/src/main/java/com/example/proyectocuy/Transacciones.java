package com.example.proyectocuy;

import android.widget.Toast;

import com.example.proyectocuy.ModeloDatos.Cuy;
import com.example.proyectocuy.ModeloDatos.Transaccion;
import com.example.proyectocuy.Recursos_Adicionales.Fechas;

public class Transacciones {

    public static Transaccion generarTransaccion(String usuarioID)
    {
        Transaccion transac=new Transaccion();
        try {
            transac.setIdUsuario(usuarioID);
            transac.setFecha(Fechas.mostrarFechaHoy());
            if (BD_ProduccionCuyes.registrarTransaccion(transac)==false)
                throw new Exception("Ocurrio un error");
            else return transac;
        }catch (Exception e)
        {
            return null;
        }
    }

    public static void RegistrarEntradaCuyes(Cuy cuy, Transaccion transaccion)
    {
        BD_ProduccionCuyes.registrarCuy(cuy);
        BD_ProduccionCuyes.registrarDetalle(transaccion.getIdTransaccion(),cuy.cuyId,"IN");
    }

    public static  void RegistrarSalidaCuyes(Cuy cuy,Transaccion transaccion)
    {


    }



}
