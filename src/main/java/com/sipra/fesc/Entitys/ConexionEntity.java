package com.sipra.fesc.Entitys;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "empresaconexion")
public class ConexionEntity implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity entidadUsuario;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresaEntity;

    public UsuarioEntity getEntidadUsuario() {
        return entidadUsuario;
    }

    public void setEntidadUsuario(UsuarioEntity entidadUsuario) {
        this.entidadUsuario = entidadUsuario;
    }

    public EmpresaEntity getEmpresaEntity() {
        return empresaEntity;
    }

    public void setEmpresaEntity(EmpresaEntity empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
