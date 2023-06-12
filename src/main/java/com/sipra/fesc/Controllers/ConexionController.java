package com.sipra.fesc.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipra.fesc.Models.Peticiones.ConexionCrearRestModel;
import com.sipra.fesc.Models.Respuestas.ConexionDataRestModel;
import com.sipra.fesc.Services.IConexionService;

@RestController
@RequestMapping("/conexion")
public class ConexionController {

    @Autowired
    IConexionService iConexionService;

    @PostMapping("/crear")
    public ConexionDataRestModel crearConexion(@RequestBody ConexionCrearRestModel conexionCrearRestModel) {
        return iConexionService.crearConexion(conexionCrearRestModel);
    }

    @GetMapping("/{id}")
    public ConexionDataRestModel getConexion(@PathVariable long id) {
        return iConexionService.getConexion(id);
    }

}
