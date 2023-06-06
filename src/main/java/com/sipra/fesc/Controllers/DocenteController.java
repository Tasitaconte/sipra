package com.sipra.fesc.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipra.fesc.Models.Peticiones.UsuarioActualizarRestModel;
import com.sipra.fesc.Models.Respuestas.UsuarioDataRestModel;
import com.sipra.fesc.Services.IDocenteService;
import com.sipra.fesc.Shared.UsuarioDto;

@RestController
@RequestMapping("/docente")
public class DocenteController {
    
    @Autowired
    IDocenteService iDocenteService;

    @Autowired
    ModelMapper modelMapper;
    // @Autowired
    

    @PostMapping("/actualizar/docente")
    public UsuarioDataRestModel actualizarDocente(@RequestBody UsuarioActualizarRestModel usuarioActualizarRestModel) {
        // return UsuarioDataRestModel usuarioDataRestModel;
        UsuarioDto usuarioActuDto = modelMapper.map(usuarioActualizarRestModel, UsuarioDto.class);
        // return iDocenteService.
        
        throw new UsernameNotFoundException(null, null);
    }
   
}
