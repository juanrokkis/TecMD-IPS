package edu.tecmd.ips.persistence.crud;

import edu.tecmd.ips.persistence.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository extends CrudRepository<Doctor, Integer> {
}
