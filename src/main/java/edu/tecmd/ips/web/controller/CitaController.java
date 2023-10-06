package edu.tecmd.ips.web.controller;

import edu.tecmd.ips.persistence.entity.Cita;
import edu.tecmd.ips.service.CitaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/usuario/{id}")
    @ApiOperation(value = "Obtener citas por ID de usuario", response = Cita.class)
    public ResponseEntity<?> getDates(@PathVariable int id){
        Optional<Cita> citas = citaService.getAllByIdUsuario(id);
        if (citas.isPresent()) {
            return new ResponseEntity<>(citas.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cancel/{id}")
    @ApiOperation(value = "Cancelar cita por ID", response = String.class)
    public ResponseEntity<?> cancel(@PathVariable int id){
        boolean canceled = citaService.cancelDateById(id);
        if (canceled) {
            return new ResponseEntity<>("Cita cancelada correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo cancelar la cita o no se encontro la cita", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guardar una nueva cita", response = Cita.class)
    public ResponseEntity<Cita> saveDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha,
            @RequestParam int idUsuario,
            @RequestParam int idDoctor
            ){
        Cita cita = citaService.save(fecha, idUsuario, idDoctor);
        return  (cita!=null) ? ResponseEntity.ok(cita) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
