import { Injectable } from '@angular/core';
import { api } from './api.service';

@Injectable({
  providedIn: 'root',
})
export class CitasMedicasService {
  async getCitasPorPaciente(pacienteId: number): Promise<any> {
    try {
      const response = await api.post('/citas/paciente', { id: pacienteId });
      return response.data;
    } catch (error) {
      console.error('Error al obtener citas por paciente', error);
      throw error;
    }
  }

  async getCitasPorMedico(medicoId: number): Promise<any> {
    try {
      const response = await api.post(`/citas/medico`, { id: medicoId });
      return response.data;
    } catch (error) {
      console.error('Error al obtener citas por médico', error);
      throw error;
    }
  }

  async agregarCitaMedica(cita: any): Promise<any> {
    try {
      const response = await api.post('/citas', cita);
      return response.data;
    } catch (error) {
      console.error('Error al agregar cita médica', error);
      throw error;
    }
  }

  async getCitasMedicas(): Promise<any> {
    try {
      const response = await api.get('/citas');
      return response.data;
    } catch (error) {
      console.error('Error al obtener citas médicas', error);
      throw error;
    }
  }
}
