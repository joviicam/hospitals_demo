import { Injectable } from '@angular/core';
import { api } from './api.service';

@Injectable({
  providedIn: 'root',
})
export class PacientesService {
  async getPacientes(): Promise<any> {
    try {
      const response = await api.get('/pacientes');
      return response.data;
    } catch (error) {
      console.error('Error al obtener pacientes', error);
      throw error;
    }
  }

  async agregarPaciente(paciente: any): Promise<any> {
    try {
      const response = await api.post('/pacientes', paciente);
      return response.data;
    } catch (error) {
      console.error('Error al agregar paciente', error);
      throw error;
    }
  }
}
