package com.example.hospitals_demo.service;

import com.example.hospitals_demo.model.CitaMedica;
import com.example.hospitals_demo.model.Medico;
import com.example.hospitals_demo.model.Paciente;
import com.example.hospitals_demo.repository.CitaMedicaRepository;
import com.example.hospitals_demo.repository.MedicoRepository;
import com.example.hospitals_demo.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaMedicaService {
    private final CitaMedicaRepository repository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;


    public CitaMedicaService(CitaMedicaRepository repository,
                             MedicoRepository medicoRepository,
                             PacienteRepository pacienteRepository) {
        this.repository = repository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public CitaMedica agendarCita(CitaMedica cita) {
        // Validar existencia de médico
        if (cita.getMedico() == null || cita.getMedico().getId() == null ||
                medicoRepository.findById(cita.getMedico().getId()) == null ) {
            throw new IllegalArgumentException("El médico con ID " + (cita.getMedico() != null ? cita.getMedico().getId() : "null") + " no existe.");
        }

        // Validar existencia de paciente
        if (cita.getPaciente() == null || cita.getPaciente().getId() == null ||
                pacienteRepository.findById(cita.getPaciente().getId()) == null){
            throw new IllegalArgumentException("El paciente con ID " + (cita.getPaciente() != null ? cita.getPaciente().getId() : "null") + " no existe.");
        }

        List<CitaMedica> citasExistentes = repository.findByMedicoAndPacienteAndFechaAndHora(
                cita.getMedico(), cita.getPaciente(), cita.getFecha(), cita.getHora());

        if (!citasExistentes.isEmpty()) {
            throw new IllegalArgumentException("Ya existe una cita para este médico y paciente en la misma fecha y hora.");
        }


        return repository.save(cita);
    }

    public List<CitaMedica> obtenerHistorialPorPaciente(Paciente paciente) {
        return repository.findByPaciente(paciente);
    }

    public List<CitaMedica> obtenerHistorialPorMedico(Medico medico) {
        return repository.findByMedico(medico);
    }

    public List<CitaMedica> obtenerCitasMedicas() {
        return repository.findAll();
    }


}
