import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { PacientesService } from '../../services/pacientes.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { get } from 'node:http';
declare const bootstrap: any;

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
    this.getPacientes();
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

  async getPacientes() {
    try {
      this.pacientes = await this.pacientesService.getPacientes();
    } catch (err) {
      console.error('Error al obtener pacientes:', err);
    }
  }

  registrarPaciente() {
    this.pacientesService
      .agregarPaciente(this.nuevoPaciente)
      .then((pacienteCreado) => {
        this.getPacientes();
        this.nuevoPaciente = {
          nombre: '',
          edad: null,
          antecedentesMedicos: '',
        };

        const modalElement = document.getElementById('registroPacienteModal');
        const modalInstance = bootstrap.Modal.getInstance(modalElement);
        modalInstance?.hide();

        setTimeout(() => {
          const backdrop = document.querySelector('.modal-backdrop');
          if (backdrop) {
            backdrop.remove();
          }

          document.body.classList.remove('modal-open');

          document.body.style.removeProperty('padding-right');
        }, 300);
      })
      .catch((err) => console.error('Error al registrar paciente:', err));
  }
}
