package com.sipra.fesc.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sipra.fesc.Entitys.UsuarioEntity;
import com.sipra.fesc.Models.Respuestas.UsuarioDataRestModel;
import com.sipra.fesc.Repositories.IUsuarioRepository;
import com.sipra.fesc.Shared.UsuarioDto;

@Service
public class DocenteService implements IDocenteService {

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UsuarioDataRestModel actualizarDocente(UsuarioDto usuarioactDto, String idUsuario) {
        UsuarioEntity usuarioEntity = iUsuarioRepository.findByIdUser(idUsuario);
        if (usuarioEntity == null) {
            throw new UsernameNotFoundException("No existe el usuario");
        }
        usuarioEntity.setPasswordEncriptada(bCryptPasswordEncoder.encode(usuarioactDto.getPassword()));
        UsuarioEntity usuarioActuEntity = iUsuarioRepository.save(usuarioEntity);

        UsuarioDto usuarioDto = modelMapper.map(usuarioActuEntity, UsuarioDto.class);

        UsuarioDataRestModel usuarioDataRestModel = modelMapper.map(usuarioDto, UsuarioDataRestModel.class);
        return usuarioDataRestModel;
    }
}
