import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { MedicosService } from '../../services/medicos.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
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
    this.medicosService
      .getMedicos()
      .then((data) => {
        this.medicos = data;
        console.log('Médicos:', this.medicos);
      })
      .catch((err) => {
        console.error('Error al obtener médicos:', err);
      });
  }

  registrarMedico() {
    this.medicosService
      .agregarMedico(this.nuevoMedico)
      .then((data) => {
        console.log('Médico registrado:', data);
        this.medicosService.getMedicos();
        this.nuevoMedico = { nombre: '', especialidad: '' };
      })

      .catch((err) => {
        console.error('Error al registrar médico:', err);
      });
  }
}
