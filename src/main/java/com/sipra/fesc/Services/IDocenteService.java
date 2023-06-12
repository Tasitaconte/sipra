package com.sipra.fesc.Services;

import com.sipra.fesc.Models.Respuestas.UsuarioDataRestModel;
import com.sipra.fesc.Shared.UsuarioDto;

public interface IDocenteService {
    
    UsuarioDataRestModel actualizarDocente(UsuarioDto usuarioactDto, String idUsuario);

}
