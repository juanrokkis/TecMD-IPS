package edu.tecmd.ips.persistence.crud;

import edu.tecmd.ips.persistence.entity.Cita;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaCrudRepository extends CrudRepository<Cita, Integer> {

    @Query(value = "select * from ips.citas where user_id = ?", nativeQuery = true)
    List<Cita> findByIdUser(int idUsuario);

}
