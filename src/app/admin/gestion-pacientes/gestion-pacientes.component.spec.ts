import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionPacientesComponent } from './gestion-pacientes.component';

describe('GestionPacientesComponent', () => {
  let component: GestionPacientesComponent;
  let fixture: ComponentFixture<GestionPacientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GestionPacientesComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(GestionPacientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
