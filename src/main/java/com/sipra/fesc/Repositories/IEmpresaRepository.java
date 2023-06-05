package com.sipra.fesc.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sipra.fesc.Entitys.EmpresaEntity;

@Repository
public interface IEmpresaRepository extends CrudRepository<EmpresaEntity, Long> {

    EmpresaEntity findById(long id);

    public List<EmpresaEntity> findAll();

    EmpresaEntity findByNit(String nit);

}
