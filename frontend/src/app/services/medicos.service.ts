import { Injectable } from '@angular/core';
import { api } from './api.service';

@Injectable({
  providedIn: 'root',
})
export class MedicosService {
  async getMedicos(): Promise<any> {
    try {
      const response = await api.get('/medicos');
      return response.data;
    } catch (error) {
      console.error('Error al obtener médicos', error);
      throw error;
    }
  }

  async agregarMedico(medico: any): Promise<any> {
    try {
      const response = await api.post('/medicos', medico);
      return response.data;
    } catch (error) {
      console.error('Error al agregar médico', error);
      throw error;
    }
  }
}
