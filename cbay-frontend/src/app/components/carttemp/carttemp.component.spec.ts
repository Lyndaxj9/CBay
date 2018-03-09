import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarttempComponent } from './carttemp.component';

describe('CarttempComponent', () => {
  let component: CarttempComponent;
  let fixture: ComponentFixture<CarttempComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarttempComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarttempComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
