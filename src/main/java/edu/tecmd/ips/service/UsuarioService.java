package edu.tecmd.ips.service;

import edu.tecmd.ips.persistence.UsuarioRepository;
import edu.tecmd.ips.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean save(String nombre, String apellido, String correo, String contraseña, String telefono, String direccion){
        try {
            if (!usuarioRepository.isCorreoUnico(correo)){
                return false;
            }
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setCorreo(correo);
            usuario.setContrasena(contraseña);
            usuario.setTelefono(telefono);
            usuario.setDireccion(direccion);
            usuarioRepository.save(usuario);
            return true;
        } catch (Exception e ){
            e.printStackTrace();
            return false;
        }
    }

    public Optional<Usuario> login(String correo, String contrasena){
        return Optional.ofNullable(usuarioRepository.login(correo, contrasena));
    }

    public Optional<Usuario> getById(int id) {
        return usuarioRepository.getById(id);
    }

}
