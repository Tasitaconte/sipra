package com.sipra.fesc.Entitys;

import jakarta.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "rol")
public class RolesEntity {
    
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 20)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadRol")
    private List<UsuarioEntity> entidadRolList = new ArrayList<>();

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

    public List<UsuarioEntity> getEntidadRolList() {
        return entidadRolList;
    }

    public void setEntidadRolList(List<UsuarioEntity> entidadRolList) {
        this.entidadRolList = entidadRolList;
    }


}
