package com.example.proyectocuy.ModeloDatos;

public class FilaMovEntradaSalida_Reporte {
    public String fecha;
    public String razon;
    public String idPoza;

    public FilaMovEntradaSalida_Reporte(String fecha, String razon, String idPoza) {
        this.fecha = fecha;
        this.razon = razon;
        this.idPoza = idPoza;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getIdPoza() {
        return idPoza;
    }

    public void setIdPoza(String idPoza) {
        this.idPoza = idPoza;
    }
}
