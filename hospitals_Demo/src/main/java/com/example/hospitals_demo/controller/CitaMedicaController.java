package com.example.hospitals_demo.controller;

import com.example.hospitals_demo.model.CitaMedica;
import com.example.hospitals_demo.model.Medico;
import com.example.hospitals_demo.model.Paciente;
import com.example.hospitals_demo.service.CitaMedicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/citas")
public class CitaMedicaController {

    private final CitaMedicaService service;

    public CitaMedicaController(CitaMedicaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> agendarCita(@Valid @RequestBody CitaMedica cita, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errores = new StringBuilder("Faltan campos obligatorios: ");
            result.getFieldErrors().forEach(error -> errores.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; "));
            return ResponseEntity.badRequest().body(errores.toString());
        }

        try {
            return ResponseEntity.ok(service.agendarCita(cita));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/paciente")
    public List<CitaMedica> historialPorPaciente(@RequestBody Paciente paciente) {
        return service.obtenerHistorialPorPaciente(paciente);
    }

    @PostMapping("/medico")
    public List<CitaMedica> historialPorMedico(@RequestBody Medico medico) {
        return service.obtenerHistorialPorMedico(medico);
    }

    @GetMapping
    public List<CitaMedica> listarCitas() {
        return service.obtenerCitasMedicas();
    }

}
