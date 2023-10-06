package edu.tecmd.ips.persistence;

import edu.tecmd.ips.persistence.crud.DoctorCrudRepository;
import edu.tecmd.ips.persistence.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class DoctorRepository {

    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    public List<Doctor> getAll(){
        return (List<Doctor>) doctorCrudRepository.findAll();
    }

    public Optional<Doctor> getById(int id) {
        return doctorCrudRepository.findById(id);
    }

}
