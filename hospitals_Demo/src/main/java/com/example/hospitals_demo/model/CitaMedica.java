package com.example.hospitals_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"medico_id", "paciente_id", "fecha", "hora"})
)
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cita_seq")
    @SequenceGenerator(name = "cita_seq", sequenceName = "cita_seq", allocationSize = 1)
    private Long id;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotNull(message = "La hora es obligatoria")
    private LocalTime hora;

    @NotNull(message = "El médico es obligatorio")
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @NotNull(message = "El paciente es obligatorio")
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @NotBlank(message = "El diagnóstico es obligatorio")
    private String diagnostico;

    @NotBlank(message = "El tratamiento es obligatorio")
    private String tratamiento;
}
