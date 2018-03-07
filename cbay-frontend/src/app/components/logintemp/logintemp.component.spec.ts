import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogintempComponent } from './logintemp.component';

describe('LogintempComponent', () => {
  let component: LogintempComponent;
  let fixture: ComponentFixture<LogintempComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogintempComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogintempComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
