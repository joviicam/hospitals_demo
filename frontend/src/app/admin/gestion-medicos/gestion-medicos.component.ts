import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { MedicosService } from '../../services/medicos.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
declare const bootstrap: any;

@Component({
  selector: 'app-gestion-medicos',
  templateUrl: './gestion-medicos.component.html',
  standalone: true,
  imports: [CommonModule, FormsModule],
})
export class GestionMedicosComponent implements OnInit {
  @ViewChild('modalMedico') modalMedicoRef!: ElementRef;
  medicos: any[] = [];

  nuevoMedico: { nombre: string; especialidad: string } = {
    nombre: '',
    especialidad: '',
  };

  constructor(private medicosService: MedicosService) {}

  ngOnInit(): void {
    this.getMedicos();
  }

  async getMedicos() {
    try {
      this.medicos = await this.medicosService.getMedicos();
    } catch (err) {
      console.error('Error al obtener médicos:', err);
    }
  }

  registrarMedico() {
    this.medicosService
      .agregarMedico(this.nuevoMedico)
      .then((data) => {
        this.getMedicos();
        this.nuevoMedico = { nombre: '', especialidad: '' };
        const modalElement = document.getElementById('registroMedicoModal');
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

      .catch((err) => {
        console.error('Error al registrar médico:', err);
      });
  }
}
