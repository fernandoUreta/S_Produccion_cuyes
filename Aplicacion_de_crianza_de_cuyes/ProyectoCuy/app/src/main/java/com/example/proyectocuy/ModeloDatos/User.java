package com.example.proyectocuy.ModeloDatos;

public class User {
    private String id;
    private String nombres;
    private String numcontacto;
    private String correo;
    private String clave;

    public User(String id, String nombres, String numcontacto, String correo, String clave) {
        this.id = id;
        this.nombres = nombres;
        this.numcontacto = numcontacto;
        this.correo = correo;
        this.clave = clave;
    }
    public User(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumcontacto() {
        return numcontacto;
    }

    public void setNumcontacto(String numcontacto) {
        this.numcontacto = numcontacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
