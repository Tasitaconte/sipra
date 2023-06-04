package com.sipra.fesc.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sipra.fesc.Entitys.RolesEntity;
import com.sipra.fesc.Entitys.UsuarioEntity;
import com.sipra.fesc.Models.Respuestas.UsuarioDataRestModel;
import com.sipra.fesc.Repositories.IRolRepository;
import com.sipra.fesc.Repositories.IUsuarioRepository;
import com.sipra.fesc.Shared.UsuarioDto;

public class UsuarioService implements IUsuarioService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUsuarioRepository iUserRepository;

    @Autowired
    IRolRepository iRolRepositories;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UsuarioDataRestModel crearUser(UsuarioDto userCrearDto, Long id) {
        RolesEntity entidadRol = iRolRepositories.findById(id.longValue());
        UsuarioEntity entidadUsuario = iUserRepository.findByEmail(userCrearDto.getEmail());

        if (entidadRol == null) {
            throw new UsernameNotFoundException("Rol no encontrado");
        }

        if (entidadUsuario != null) {
            throw new UsernameNotFoundException("Correo ya usado");
        }

        UsuarioEntity userEntidad = modelMapper.map(userCrearDto, UsuarioEntity.class);
        userEntidad.setIdUser(UUID.randomUUID().toString());
        userEntidad.setEntidadRol(entidadRol);
        userEntidad.setPasswordEncriptada(bCryptPasswordEncoder.encode(userCrearDto.getPassword()));
        UsuarioEntity userCreado = iUserRepository.save(userEntidad);
        UsuarioDto userDto = modelMapper.map(userCreado, UsuarioDto.class);
        UsuarioDataRestModel useDataRestModel = modelMapper.map(userDto, UsuarioDataRestModel.class);
        return useDataRestModel;
    }

    @Override
    public List<UsuarioDataRestModel> leerEstudiantes() {
        List<UsuarioEntity> usersEntidad = iUserRepository.FindByEstudiantesAll();
        List<UsuarioDataRestModel> usersDataRestModel = new ArrayList<>();

        for (UsuarioEntity userEntidad : usersEntidad) {
            UsuarioDataRestModel userDto = modelMapper.map(userEntidad, UsuarioDataRestModel.class);
            usersDataRestModel.add(userDto);
        }
       
        return usersDataRestModel;
    }
}
