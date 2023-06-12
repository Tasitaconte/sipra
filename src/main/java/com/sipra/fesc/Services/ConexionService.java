package com.sipra.fesc.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sipra.fesc.Entitys.ConexionEntity;
import com.sipra.fesc.Entitys.EmpresaEntity;
import com.sipra.fesc.Entitys.UsuarioEntity;
import com.sipra.fesc.Models.Peticiones.ConexionCrearRestModel;
import com.sipra.fesc.Models.Respuestas.ConexionDataRestModel;
import com.sipra.fesc.Repositories.IConexionRepository;
import com.sipra.fesc.Repositories.IEmpresaRepository;
import com.sipra.fesc.Repositories.IUsuarioRepository;
import com.sipra.fesc.Shared.ConexionDto;

@Service
public class ConexionService implements IConexionService {

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    IEmpresaRepository iEmpresaRepository;

    @Autowired
    IConexionRepository iConexionRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ConexionDataRestModel crearConexion(ConexionCrearRestModel conexionCrearRestModel) {

        UsuarioEntity usuarioEntity = iUsuarioRepository.findById(conexionCrearRestModel.getIdUsuario());
        EmpresaEntity empresaEntity = iEmpresaRepository.findById(conexionCrearRestModel.getIdEmpresa());

        if (empresaEntity == null) {
            throw new UsernameNotFoundException("empresa no encontrado");
        }

        if (usuarioEntity == null) {
            throw new UsernameNotFoundException("usuario no encontrado");
        }

        ConexionEntity conexionEntity = new ConexionEntity();

        conexionEntity.setEmpresaEntity(empresaEntity);
        conexionEntity.setEntidadUsuario(usuarioEntity);

        ConexionEntity conexionCreada = iConexionRepository.save(conexionEntity);
        ConexionDto conexionDto = modelMapper.map(conexionCreada, ConexionDto.class);

        ConexionDataRestModel conexionDataRestModel = modelMapper.map(conexionDto, ConexionDataRestModel.class);
        return conexionDataRestModel;
    }

    @Override
    public ConexionDataRestModel getConexion(long id) {
        ConexionEntity conexionEntity = iConexionRepository.findById(id);
        ConexionDto conexionDto = modelMapper.map(conexionEntity, ConexionDto.class);
        ConexionDataRestModel conexionDataRestModel = modelMapper.map(conexionDto, ConexionDataRestModel.class);
        return conexionDataRestModel;
    }

}
