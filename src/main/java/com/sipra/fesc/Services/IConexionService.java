package com.sipra.fesc.Services;
import com.sipra.fesc.Models.Peticiones.ConexionCrearRestModel;
import com.sipra.fesc.Models.Respuestas.ConexionDataRestModel;

public interface IConexionService {
    public ConexionDataRestModel crearConexion(ConexionCrearRestModel conexionCrearRestModel);
    public ConexionDataRestModel getConexion(long id);
}
