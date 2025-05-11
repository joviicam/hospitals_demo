package com.example.hospitals_demo.controller;

import com.example.hospitals_demo.model.Medico;
import com.example.hospitals_demo.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @GetMapping
    public List<Medico> listarMedicos() {
        return medicoService.getAllMedicos();
    }

    @GetMapping("/{id}")
    public Medico obtenerMedico(@PathVariable Long id) {
        return medicoService.getMedicoById(id);
    }

    @PostMapping
    public ResponseEntity<String> registrarMedico(@Valid @RequestBody Medico medico, BindingResult result) {

        if (result.hasErrors()) {
            StringBuilder errores = new StringBuilder("Faltan campos obligatorios: ");
            result.getFieldErrors().forEach(error -> errores.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; "));
            return ResponseEntity.badRequest().body(errores.toString());
        }

        medicoService.saveMedico(medico);
        return null;
    }

    @PutMapping("/{id}")
    public void actualizarMedico(@PathVariable Long id, @RequestBody Medico medico) {
        medico.setId(id);
        medicoService.saveMedico(medico);
    }

    @DeleteMapping("/{id}")
    public void eliminarMedico(@PathVariable Long id) {
        medicoService.deleteMedico(id);
    }
}
