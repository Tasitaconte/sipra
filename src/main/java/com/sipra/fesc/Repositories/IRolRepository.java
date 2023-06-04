package com.sipra.fesc.Repositories;

import java.util.List;
import com.sipra.fesc.Entitys.RolesEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends CrudRepository<RolesEntity, Long> {
    RolesEntity findById(long id);
    public List<RolesEntity> findAll();
}
