package edu.tecmd.ips.persistence.crud;

import edu.tecmd.ips.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {

    Usuario findByCorreoAndContrasena(String correo, String contraseña);

    Usuario findByCorreo(String correo);

}
