package edu.tecmd.ips.web.controller;

import edu.tecmd.ips.persistence.entity.Usuario;
import edu.tecmd.ips.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public String registrarUsuario(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String correo,
            @RequestParam String contrasena,
            @RequestParam String telefono,
            @RequestParam String direccion
    ) {
        if (usuarioService.save(nombre, apellido, correo, contrasena, telefono, direccion)) {
            return "Usuario registrado con éxito";
        } else {
            return "El correo ya está en uso";
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam String correo,
            @RequestParam String contrasena) {
        Optional<Usuario> usuarioLogueado = usuarioService.login(correo, contrasena);
        if (usuarioLogueado.isPresent()) {
            return ResponseEntity.ok("Inicio de sesión exitoso.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas.");
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id){
        Optional<Usuario> usuario = usuarioService.getById(id);
        if (usuario.isPresent()) {
            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

}
