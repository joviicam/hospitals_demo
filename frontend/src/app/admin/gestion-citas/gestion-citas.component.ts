import { Component, OnInit } from '@angular/core';
import { CitasMedicasService } from '../../services/citasMedicas.service';
import { PacientesService } from '../../services/pacientes.service';
import { MedicosService } from '../../services/medicos.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
declare const bootstrap: any;

@Component({
  selector: 'app-gestion-citas',
  templateUrl: './gestion-citas.component.html',
  imports: [CommonModule, FormsModule],
})
export class GestionCitasComponent implements OnInit {
  citas: any[] = [];
  pacienteId: number | null = null;
  medicoId: number | null = null;

  constructor(
    private citasService: CitasMedicasService,
    private pacientesService: PacientesService,
    private medicoService: MedicosService
  ) {}

  ngOnInit(): void {
    this.cargarCitas();
    this.cargarPacientes();
    this.cargarMedicos();
  }

  async cargarCitas() {
    try {
      this.citas = await this.citasService.getCitasMedicas();
    } catch (err) {
      console.error('Error al obtener citas:', err);
    }
  }

  async cargarCitasPorPaciente() {
    if (this.pacienteId) {
      try {
        this.citas = await this.citasService.getCitasPorPaciente(
          this.pacienteId
        );
      } catch (err) {
        console.error('Error al obtener citas por paciente:', err);
      }
    } else if (!this.pacienteId && !this.medicoId) {
      this.cargarCitas();
    }
  }

  async cargarCitasPorMedico() {
    if (this.medicoId) {
      try {
        this.citas = await this.citasService.getCitasPorMedico(this.medicoId);
      } catch (err) {
        console.error('Error al obtener citas por médico:', err);
      }
    } else if (!this.pacienteId && !this.medicoId) {
      this.cargarCitas();
    }
  }
  nuevaCita = {
    fecha: '',
    hora: '',
    medico: { id: null },
    paciente: { id: null },
    diagnostico: '',
    tratamiento: '',
  };

  pacientes: any[] = [];
  medicos: any[] = [];

  registrarCita(): void {
    this.citasService
      .agregarCitaMedica(this.nuevaCita)
      .then(() => {
        this.cargarCitas();
        const modalElement = document.getElementById('registroCitaModal');
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
      .catch((err: unknown) => {
        if (err instanceof Error) {
          console.error('Error registrando cita', err.message);
        } else {
          console.error('Error registrando cita', err);
        }
      });
  }

  async cargarPacientes() {
    this.pacientes = await this.pacientesService.getPacientes();
  }

  async cargarMedicos() {
    this.medicos = await this.medicoService.getMedicos();
  }
}
