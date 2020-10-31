package com.example.appproduccioncuyes.ModeloDatos;

public class Actividad extends Cuy{

    int edad;
    String tipoCuy;

    public void setCuyId(String idCuy) {
        super.cuyId = idCuy;
    }
    @Override
    public void setIdPoza(String idPoza) {
        super.idPoza = idPoza;
    }

    public String getCuyId()
    {
        return super.cuyId;
    }
    public String getIdPoza()
    {
        return super.idPoza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
