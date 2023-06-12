package com.sipra.fesc.Models.Respuestas;

public class ConexionDataRestModel {

    private long id;
    private UsuarioDataRestModel usuarioEntity;
    private EmpresaDataRestModel empresaEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UsuarioDataRestModel getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioDataRestModel usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public EmpresaDataRestModel getEmpresaEntity() {
        return empresaEntity;
    }

    public void setEmpresaEntity(EmpresaDataRestModel empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

}
