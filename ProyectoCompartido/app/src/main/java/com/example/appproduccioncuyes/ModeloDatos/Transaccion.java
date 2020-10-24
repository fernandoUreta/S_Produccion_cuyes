package com.example.appproduccioncuyes.ModeloDatos;


import com.example.appproduccioncuyes.ConexionBD.BD_ProduccionCuyes;

import java.sql.Date;

public class Transaccion {
    private int idTransaccion;
    private String idUsuario;
    private java.sql.Date fecha;


    public Transaccion() {
        this.idTransaccion = obtenerID();
    }

    public int obtenerID()
    {
        int ultimo= BD_ProduccionCuyes.consultarUltimaTransaccion();
        return ultimo+1;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
