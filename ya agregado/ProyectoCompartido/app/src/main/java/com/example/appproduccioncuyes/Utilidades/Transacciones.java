package com.example.appproduccioncuyes.Utilidades;

import com.example.appproduccioncuyes.ConexionBD.BD_ProduccionCuyes;
import com.example.appproduccioncuyes.ModeloDatos.Cuy;
import com.example.appproduccioncuyes.ModeloDatos.Transaccion;
import com.example.appproduccioncuyes.Recursos_Adicionales.Fechas;


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

    public static void RegistrarEntradaCuyes(Cuy cuy, Transaccion transaccion,String tipoMovi)
    {
        String movimiento="";
        switch (tipoMovi)
        {
            case "Compra":movimiento="IC";break;
            case "Nacimiento":movimiento="IN";break;
            case "Rotacion":movimiento="IR";break;
            case "Otros":movimiento="IO";break;
        }
        BD_ProduccionCuyes.registrarCuy(cuy);
        BD_ProduccionCuyes.registrarDetalle(transaccion.getIdTransaccion(),cuy.cuyId,movimiento);
    }

    public static  void RegistrarSalidaCuyes(Cuy cuy,Transaccion transaccion,String idPozaDestino,String tipoMovi)
    {
        BD_ProduccionCuyes.eliminarCuy(cuy.cuyId);
        cuy.setIdPoza(idPozaDestino);
        BD_ProduccionCuyes.registrarCuy(cuy);

        String movimiento="";
        switch (tipoMovi)
        {
            case "Muerte":movimiento="SM";break;
            case "Venta":movimiento="SV";break;
            case "Consumo":movimiento="SC";break;
            case "Rotación":movimiento="SR";break;
            case "Otros":movimiento="SO";break;
        }
        BD_ProduccionCuyes.registrarDetalle(transaccion.getIdTransaccion(),cuy.cuyId,movimiento);
    }



}
