import { Routes } from '@angular/router';
import { LandingPageComponent } from './pages/landing-page/landing-page.component';
import { AdminLayoutComponent } from './layout/admin-layout/admin-layout.component';
import { GestionCitasComponent } from './admin/gestion-citas/gestion-citas.component';
import { GestionMedicosComponent } from './admin/gestion-medicos/gestion-medicos.component';
import { GestionPacientesComponent } from './admin/gestion-pacientes/gestion-pacientes.component';

export const routes: Routes = [
  { path: '', component: LandingPageComponent },
  {
    path: 'admin',
    component: AdminLayoutComponent,
    children: [
      { path: 'pacientes', component: GestionPacientesComponent },
      { path: 'medicos', component: GestionMedicosComponent },
      { path: 'citas', component: GestionCitasComponent },
      { path: '', redirectTo: 'pacientes', pathMatch: 'full' },
    ],
  },
  { path: '**', redirectTo: '' },
];
