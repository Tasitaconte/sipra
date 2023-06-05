package com.sipra.fesc.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipra.fesc.Models.Peticiones.EmpresaCrearRestModel;
import com.sipra.fesc.Models.Respuestas.EmpresaDataRestModel;
import com.sipra.fesc.Services.IEmpresaService;
import com.sipra.fesc.Shared.EmpresaDto;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    IEmpresaService iEmpresaService;
    
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public EmpresaDataRestModel crearEmpresas(@RequestBody EmpresaCrearRestModel empresaCrearRestModel) {        
        EmpresaDto empresaCrearDto = modelMapper.map(empresaCrearRestModel, EmpresaDto.class);
        return iEmpresaService.crearEmpresa(empresaCrearDto);
    }
}
