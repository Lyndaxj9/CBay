import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GenericlistComponent } from './genericlist.component';

describe('GenericlistComponent', () => {
  let component: GenericlistComponent;
  let fixture: ComponentFixture<GenericlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GenericlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GenericlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
