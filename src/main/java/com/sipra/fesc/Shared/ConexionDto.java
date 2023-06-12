package com.sipra.fesc.Shared;

import java.io.Serializable;

public class ConexionDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private long id;
    UsuarioDto usuarioEntity;
    EmpresaDto empresaEntity;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UsuarioDto getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioDto usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public EmpresaDto getEmpresaEntity() {
        return empresaEntity;
    }

    public void setEmpresaEntity(EmpresaDto empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

}
