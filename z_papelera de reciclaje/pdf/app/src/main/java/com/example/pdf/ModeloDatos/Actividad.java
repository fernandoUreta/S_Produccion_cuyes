package com.example.pdf.ModeloDatos;

public class Actividad {

    private String idPoza;
    private String idCuy;
    private int cuyEdad;
    private String genero;
    private String categoria;
    private String descripcion;

    public Actividad(String idPoza, String idCuy, int cuyEdad, String genero, String categoria,String descripcion) {
        this.idPoza = idPoza;
        this.idCuy = idCuy;
        this.cuyEdad = cuyEdad;
        this.genero = genero;
        this.categoria = categoria;
        this.descripcion=descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdPoza() {
        return idPoza;
    }

    public void setIdPoza(String idPoza) {
        this.idPoza = idPoza;
    }

    public String getIdCuy() {
        return idCuy;
    }

    public void setIdCuy(String idCuy) {
        this.idCuy = idCuy;
    }

    public int getCuyEdad() {
        return cuyEdad;
    }

    public void setCuyEdad(int cuyEdad) {
        this.cuyEdad = cuyEdad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

