package com.sipra.fesc.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "usuario")
@Table(indexes = {
        @Index(columnList = "idUser", name = "index_idUser", unique = true),
        @Index(columnList = "email", name = "index_email", unique = true),
        @Index(columnList = "cc", name = "index_cc", unique = true),
})
public class UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String idUser;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, length = 13)
    private String celular;

    @Column(nullable = false, length = 100)
    private String cc;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private String passwordEncriptada;

    @Column(nullable = false)
    private String programa;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RolesEntity entidadRol;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadUsuario")
    private List<ConexionEntity> conexionEntitieslList = new ArrayList<>();

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordEncriptada() {
        return passwordEncriptada;
    }

    public void setPasswordEncriptada(String passwordEncriptada) {
        this.passwordEncriptada = passwordEncriptada;
    }

    public RolesEntity getEntidadRol() {
        return entidadRol;
    }

    public void setEntidadRol(RolesEntity entidadRol) {
        this.entidadRol = entidadRol;
    }

    public List<ConexionEntity> getConexionEntitieslList() {
        return conexionEntitieslList;
    }

    public void setConexionEntitieslList(List<ConexionEntity> conexionEntitieslList) {
        this.conexionEntitieslList = conexionEntitieslList;
    }

}
