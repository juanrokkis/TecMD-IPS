package edu.tecmd.ips.service;

import edu.tecmd.ips.persistence.DoctorRepository;
import edu.tecmd.ips.persistence.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }

}
