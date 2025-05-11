package com.example.hospitals_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medico_seq")
    @SequenceGenerator(name = "medico_seq", sequenceName = "medico_seq", allocationSize = 1)
    private Long id;

    @NotNull(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "La especialidad es obligatoria")
    private String especialidad;
}
