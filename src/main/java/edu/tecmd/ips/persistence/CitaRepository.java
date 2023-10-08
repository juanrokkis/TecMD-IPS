package edu.tecmd.ips.persistence;


import edu.tecmd.ips.persistence.crud.CitaCrudRepository;
import edu.tecmd.ips.persistence.entity.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

@Repository
public class CitaRepository {

    @Autowired
    private CitaCrudRepository citaCrudRepository;

    public List<Cita> getByIdUser(int id){
        return citaCrudRepository.findByIdUser(id);
    }

    @Transactional
    public boolean cancelDateById(int id){
        Optional<Cita> optionalCita = citaCrudRepository.findById(id);

        optionalCita.ifPresent(cita -> {
            cita.setEstado("Cancelada");
            citaCrudRepository.save(cita);
        });

        return optionalCita.isPresent();
    }

    public Cita save( Cita cita ){
        return citaCrudRepository.save(cita);
    }

}
