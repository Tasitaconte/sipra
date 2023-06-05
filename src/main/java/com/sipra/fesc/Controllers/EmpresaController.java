package com.sipra.fesc.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @PostMapping
    public String crearUser() {
        // UsuarioDto userCrearDto = modelMapper.map(usuarioDataRestModel,
        // UsuarioDto.class);
        // return iUserService.crearUser(userCrearDto, idRol.longValue());
        return "Creado";
    }
}
