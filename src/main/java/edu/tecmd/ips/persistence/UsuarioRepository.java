package edu.tecmd.ips.persistence;

import edu.tecmd.ips.persistence.crud.UsuarioCrudRepository;
import edu.tecmd.ips.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    public Optional<Usuario> getById(int id) {
        return usuarioCrudRepository.findById(id);
    }

    public Usuario save (Usuario usuario){
        return usuarioCrudRepository.save(usuario);
    }

    public boolean isCorreoUnico(String correo){
        Optional<Usuario> usuario = Optional.ofNullable(usuarioCrudRepository.findByCorreo(correo));
        return usuario.isEmpty();
    }

    public Usuario login (String correo, String contrasena) {
        try {
            return usuarioCrudRepository.findByCorreoAndContrasena(correo, contrasena);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
