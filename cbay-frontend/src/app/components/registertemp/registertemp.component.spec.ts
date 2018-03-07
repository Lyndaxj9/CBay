import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistertempComponent } from './registertemp.component';

describe('RegistertempComponent', () => {
  let component: RegistertempComponent;
  let fixture: ComponentFixture<RegistertempComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistertempComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistertempComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
