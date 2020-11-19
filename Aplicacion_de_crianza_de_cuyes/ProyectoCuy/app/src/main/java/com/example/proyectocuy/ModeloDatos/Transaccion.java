package com.example.proyectocuy.ModeloDatos;



import com.example.proyectocuy.AccesoBD.BD_AccesoDatos;

import java.sql.Date;

public class Transaccion {
    private int idTransaccion;
    private String idUsuario;
    private Date fecha;


    public Transaccion() {
        this.idTransaccion = obtenerID();
    }

    public int obtenerID()
    {
        int ultimo= BD_AccesoDatos.consultarUltimaTransaccion();
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
