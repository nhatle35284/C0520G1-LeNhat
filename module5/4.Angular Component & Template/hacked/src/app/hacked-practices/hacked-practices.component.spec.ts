import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HackedPracticesComponent } from './hacked-practices.component';

describe('HackedPracticesComponent', () => {
  let component: HackedPracticesComponent;
  let fixture: ComponentFixture<HackedPracticesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HackedPracticesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HackedPracticesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
