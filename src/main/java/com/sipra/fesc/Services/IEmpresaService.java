package com.sipra.fesc.Services;

import java.util.List;

import com.sipra.fesc.Models.Respuestas.EmpresaDataRestModel;
import com.sipra.fesc.Shared.EmpresaDto;

public interface IEmpresaService {
    
    public EmpresaDataRestModel crearEmpresa(EmpresaDto empresaCrearDto);

    public List<EmpresaDataRestModel> getEmpresas();
    
}
