package com.sipra.fesc.Entitys;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "empresas")
public class EmpresaEntity {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    private String idEmpresa;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String direccion;

    @Column(nullable = false, length = 100)
    private String numero;
    
    @Column(nullable = false, length = 100)
    private String nit;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaEntity")
    private List<ConexionEntity> entidadConexionEntities = new ArrayList<>();

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<ConexionEntity> getEntidadConexionEntities() {
        return entidadConexionEntities;
    }

    public void setEntidadConexionEntities(List<ConexionEntity> entidadConexionEntities) {
        this.entidadConexionEntities = entidadConexionEntities;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

}
