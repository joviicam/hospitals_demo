import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionMedicosComponent } from './gestion-medicos.component';

describe('GestionMedicosComponent', () => {
  let component: GestionMedicosComponent;
  let fixture: ComponentFixture<GestionMedicosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GestionMedicosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GestionMedicosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
