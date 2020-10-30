import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetAngularComponent } from './pet-angular.component';

describe('PetAngularComponent', () => {
  let component: PetAngularComponent;
  let fixture: ComponentFixture<PetAngularComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetAngularComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetAngularComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
