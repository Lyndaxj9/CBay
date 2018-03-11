import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemsoldComponent } from './itemsold.component';

describe('ItemsoldComponent', () => {
  let component: ItemsoldComponent;
  let fixture: ComponentFixture<ItemsoldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItemsoldComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemsoldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
