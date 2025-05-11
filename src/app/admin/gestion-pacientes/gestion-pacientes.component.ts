import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { PacientesService } from '../../services/pacientes.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-gestion-pacientes',
  templateUrl: './gestion-pacientes.component.html',
  imports: [CommonModule, FormsModule],
  standalone: true,
})
export class GestionPacientesComponent implements OnInit {
  pacientes: any[] = [];

  constructor(private pacientesService: PacientesService) {}

  ngOnInit(): void {
    this.pacientesService
      .getPacientes()
      .then((data) => {
        this.pacientes = data;
        console.log('Pacientes:', this.pacientes);
      })
      .catch((err) => {
        console.error('Error al obtener pacientes:', err);
      });
  }
  @ViewChild('modalPaciente') modalPacienteRef!: ElementRef;

  nuevoPaciente: {
    nombre: string;
    edad: number | null;
    antecedentesMedicos: string;
  } = {
    nombre: '',
    edad: null,
    antecedentesMedicos: '',
  };

  registrarPaciente() {
    this.pacientesService
      .agregarPaciente(this.nuevoPaciente)
      .then((pacienteCreado) => {
        this.pacientesService.getPacientes();
        this.nuevoPaciente = {
          nombre: '',
          edad: null,
          antecedentesMedicos: '',
        };
      })
      .catch((err) => console.error('Error al registrar paciente:', err));
  }
}
