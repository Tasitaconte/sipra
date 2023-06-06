package com.sipra.fesc.Repositories;
import com.sipra.fesc.Entitys.UsuarioEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long> {
    UsuarioEntity findById(long id);

    UsuarioEntity findByCc(String cc);

    UsuarioEntity findByIdUser(String id);

    List<UsuarioEntity> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE id_rol LIKE 2")
    public List<UsuarioEntity> FindByEstudiantesAll();

    UsuarioEntity findByEmail(String correo);

    UsuarioEntity findOneByEmail(String email);
}
