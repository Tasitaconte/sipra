package com.sipra.fesc.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sipra.fesc.Entitys.EmpresaEntity;
import com.sipra.fesc.Models.Respuestas.EmpresaDataRestModel;
import com.sipra.fesc.Repositories.IEmpresaRepository;
import com.sipra.fesc.Shared.EmpresaDto;

@Service
public class EmpresaService implements IEmpresaService {

    @Autowired
    IEmpresaRepository iEmpresaRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public EmpresaDataRestModel crearEmpresa(EmpresaDto empresaCrearDto) {
        EmpresaEntity entidadUsuario = iEmpresaRepository.findByNit(empresaCrearDto.getNit());

        if (entidadUsuario != null) {
            throw new UsernameNotFoundException("Empresa ya creada");
        }

        EmpresaEntity empresaEntity = modelMapper.map(empresaCrearDto, EmpresaEntity.class);
        empresaEntity.setIdEmpresa(UUID.randomUUID().toString());
        EmpresaEntity empresaCreada = iEmpresaRepository.save(empresaEntity);
        EmpresaDto empresaDto = modelMapper.map(empresaCreada, EmpresaDto.class);
        EmpresaDataRestModel useDataRestModel = modelMapper.map(empresaDto, EmpresaDataRestModel.class);
        return useDataRestModel;
    }

    @Override
    public List<EmpresaDataRestModel> getEmpresas() {
        List<EmpresaEntity> empresaEntities = iEmpresaRepository.findAll();
        List<EmpresaDataRestModel> empresaDataRestModels = new ArrayList<>();

        for (EmpresaEntity empresaEntity : empresaEntities) {
            EmpresaDataRestModel empresaDataRestModel = modelMapper.map(empresaEntity, EmpresaDataRestModel.class);
            empresaDataRestModels.add(empresaDataRestModel);
        }
        
        return empresaDataRestModels;
    }

}
