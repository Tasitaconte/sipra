package com.sipra.fesc.Services;

import java.util.List;

import com.sipra.fesc.Models.Respuestas.UsuarioDataRestModel;
import com.sipra.fesc.Shared.UsuarioDto;

public interface IUsuarioService {
    public UsuarioDataRestModel crearUser(UsuarioDto userCrearDto, Long id);

    public List<UsuarioDataRestModel> leerEstudiantes();
}
