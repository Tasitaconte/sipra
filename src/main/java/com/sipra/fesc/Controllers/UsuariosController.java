package com.sipra.fesc.Controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sipra.fesc.Models.Peticiones.LoginUserDataRestModel;
import com.sipra.fesc.Models.Peticiones.UsuarioBusquedaRestModel;
import com.sipra.fesc.Models.Peticiones.UsuarioCrearRestModel;
import com.sipra.fesc.Models.Respuestas.UsuarioDataRestModel;
import com.sipra.fesc.Services.IUsuarioService;
import com.sipra.fesc.Shared.UsuarioDto;

@RestController
@RequestMapping("/usuario")
public class UsuariosController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUsuarioService iUserService;

    @PostMapping("/{idRol}")
    public UsuarioDataRestModel crearUser(@RequestBody UsuarioCrearRestModel usuarioDataRestModel,
            @PathVariable Long idRol) {
        UsuarioDto userCrearDto = modelMapper.map(usuarioDataRestModel, UsuarioDto.class);
        return iUserService.crearUser(userCrearDto, idRol.longValue());
    }

    @GetMapping("/estudiantes")
    public List<UsuarioDataRestModel> leerEstudiantes() {
        return iUserService.leerEstudiantes();
    }

    @GetMapping("/usuarioBusqueda/docente")
    public UsuarioDataRestModel BusquedaUsuarioDocente(@RequestBody UsuarioBusquedaRestModel usuarioBusquedaRestModel) {
        UsuarioDataRestModel usuarioDataRestModel = iUserService.getUsuarioCedula(usuarioBusquedaRestModel);
        if (usuarioDataRestModel.getEntidadRol().getId() != 1) {
            throw new UsernameNotFoundException("No es docente");
        }
        return usuarioDataRestModel;
    }

    @GetMapping("/usuarioBusqueda/estudiante")
    public UsuarioDataRestModel BusquedaUsuarioEstudiante(@RequestBody UsuarioBusquedaRestModel usuarioBusquedaRestModel) {
        UsuarioDataRestModel usuarioDataRestModel = iUserService.getUsuarioCedula(usuarioBusquedaRestModel);
        if (usuarioDataRestModel.getEntidadRol().getId() != 2) {
            throw new UsernameNotFoundException("No es estudiante");
        }
        return usuarioDataRestModel;
    }

    @GetMapping("/login")
    public boolean login(@RequestBody LoginUserDataRestModel loginUserDataRestModel) {
        return true;
    }


}
