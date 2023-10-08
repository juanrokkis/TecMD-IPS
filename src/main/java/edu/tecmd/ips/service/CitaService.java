package edu.tecmd.ips.service;

import edu.tecmd.ips.persistence.CitaRepository;
import edu.tecmd.ips.persistence.DoctorRepository;
import edu.tecmd.ips.persistence.UsuarioRepository;
import edu.tecmd.ips.persistence.entity.Cita;
import edu.tecmd.ips.persistence.entity.Doctor;
import edu.tecmd.ips.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Cita> getAllByIdUsuario(int idUsuario){
        return citaRepository.getByIdUser(idUsuario);
    }

    public boolean cancelDateById(int id){
        return citaRepository.cancelDateById(id);
    }

    public Cita save (LocalDateTime fecha, int usuarioId, int doctorId) {
        try {
            Cita cita = new Cita();
            cita.setFecha(fecha);
            cita.setEstado("Pendiente");
            Usuario usuario = usuarioRepository.getById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            Doctor doctor = doctorRepository.getById(doctorId).orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
            cita.setUsuario(usuario);
            cita.setDoctor(doctor);
            return citaRepository.save(cita);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
