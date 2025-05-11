package com.example.hospitals_demo.service;

import com.example.hospitals_demo.model.Paciente;
import com.example.hospitals_demo.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    public void savePaciente(Paciente paciente) {
        System.out.println("Paciente recibido: " + paciente);

        if (paciente.getId() == null) {
            pacienteRepository.insert(paciente
            );
        } else {
            pacienteRepository.update(paciente);
        }
    }

    public void deletePaciente(Long id) {
        pacienteRepository.delete(id);
    }
}
