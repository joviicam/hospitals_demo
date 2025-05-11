package com.example.hospitals_demo.repository;

import com.example.hospitals_demo.model.CitaMedica;
import com.example.hospitals_demo.model.Medico;
import com.example.hospitals_demo.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {
    List <CitaMedica> findAll();
    List<CitaMedica> findByPaciente(Paciente paciente);
    List<CitaMedica> findByMedico(Medico medico);

    List<CitaMedica> findByMedicoAndPacienteAndFechaAndHora(Medico medico, Paciente paciente, LocalDate fecha, LocalTime hora);
}
