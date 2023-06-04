package com.sipra.fesc.Models.Respuestas;

public class UsuarioDataRestModel {
    
    private long id;
    private String idUser;
    private String nombre;
    private String email;
    private String apellido;
    private String celular;
    private String cc;
    private RolDataRestModel entidadRol;

    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RolDataRestModel getEntidadRol() {
        return entidadRol;
    }

    public void setEntidadRol(RolDataRestModel entidadRol) {
        this.entidadRol = entidadRol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
