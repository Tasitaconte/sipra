package com.sipra.fesc.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sipra.fesc.Entitys.ConexionEntity;


@Repository
public interface IConexionRepository  extends CrudRepository<ConexionEntity,Long> {
    ConexionEntity findById(long id);
}
