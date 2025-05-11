package com.example.hospitals_demo.controller;

import com.example.hospitals_demo.model.Paciente;
import com.example.hospitals_demo.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.getAllPacientes();
    }

    @GetMapping("/{id}")
    public Paciente obtenerPaciente(@PathVariable Long id) {
        return pacienteService.getPacienteById(id);
    }

    @PostMapping
    public ResponseEntity<String> registrarPaciente(@Valid @RequestBody Paciente paciente, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errores = new StringBuilder("Faltan campos obligatorios: ");
            result.getFieldErrors().forEach(error -> errores.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; "));
            return ResponseEntity.badRequest().body(errores.toString());
        }

        pacienteService.savePaciente(paciente);
        return null;
    }

    @PutMapping("/{id}")
    public void actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        paciente.setId(id);
        pacienteService.savePaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }
}
