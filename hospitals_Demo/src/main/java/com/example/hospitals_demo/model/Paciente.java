package com.example.hospitals_demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_seq")
    @SequenceGenerator(name = "paciente_seq", sequenceName = "paciente_seq", allocationSize = 1)
    private Long id;

    @NotNull(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "La edad es obligatoria")
    private Integer edad;

    @NotNull(message = "Los antecedentes médicos son obligatorios")
    @Column(name = "antecedentes_medicos")
    private String antecedentesMedicos;


}
