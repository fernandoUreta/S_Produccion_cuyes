package com.example.appproduccioncuyes.ModeloDatos;

public class ActividadCardview {
    String idCuy;
    String idPoza;
    int edadCuy;

    public ActividadCardview() {

    }
    public ActividadCardview(String idCuy, String idPoza, int edadCuy) {
        this.idCuy = idCuy;
        this.idPoza = idPoza;
        this.edadCuy = edadCuy;
    }

    public String getIdCuy() {
        return idCuy;
    }

    public void setIdCuy(String idCuy) {
        this.idCuy = idCuy;
    }

    public String getIdPoza() {
        return idPoza;
    }

    public void setIdPoza(String idPoza) {
        this.idPoza = idPoza;
    }

    public int getEdadCuy() {
        return edadCuy;
    }

    public void setEdadCuy(int edadCuy) {
        this.edadCuy = edadCuy;
    }
}
