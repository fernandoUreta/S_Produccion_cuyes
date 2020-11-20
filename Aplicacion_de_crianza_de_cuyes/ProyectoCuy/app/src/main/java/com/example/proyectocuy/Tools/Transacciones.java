package com.example.proyectocuy.Tools;


import android.content.Context;
import android.widget.Toast;

import com.example.proyectocuy.AccesoBD.BD_AccesoDatos;
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
            if (BD_AccesoDatos.registrarTransaccion(transac)==false)
                throw new Exception("Ocurrio un error");
            else return transac;
        }catch (Exception e)
        {
            return null;
        }
    }

    public static void RegistrarEntradaCuyes(Cuy cuy, Transaccion transaccion, String tipoMovi,Context context)
    {

        String movimiento="";
        switch (tipoMovi)
        {
            case "Compra":movimiento="IC";break;
            case "Nacimiento":movimiento="IN";break;
            case "Rotacion":movimiento="IR";break;
            case "Otros":movimiento="IO";break;
        }
        BD_AccesoDatos.registrarCuy(cuy);
        BD_AccesoDatos.registrarDetalle(transaccion.getIdTransaccion(),cuy.getCuyId(),movimiento,context);
    }

    public static  void RegistrarSalidaCuyes(Cuy cuy, Transaccion transaccion, String idPozaDestino, String tipoMovi, Context context)
    {
        try {
            BD_AccesoDatos.eliminarCuy(cuy.getCuyId(),context);
            cuy.setIdPoza(idPozaDestino);
            BD_AccesoDatos.registrarCuy(cuy);

            String movimiento="";
            switch (tipoMovi)
            {
                case "Muerte":movimiento="SM";break;
                case "Venta":movimiento="SV";break;
                case "Consumo":movimiento="SC";break;
                case "Rotación":movimiento="SR";break;
                case "Otros":movimiento="SO";break;
            }
            BD_AccesoDatos.registrarDetalle(transaccion.getIdTransaccion(),cuy.getCuyId(),movimiento,context);
            Toast.makeText(context,"Llega aquí",Toast.LENGTH_LONG).show();
        }catch (Exception e)
        {
            Toast.makeText(context,e.toString(),Toast.LENGTH_LONG).show();
        }

    }



}
