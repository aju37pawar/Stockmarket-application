import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StockexchangeAddComponent } from './stockexchange-add.component';

describe('StockexchangeAddComponent', () => {
  let component: StockexchangeAddComponent;
  let fixture: ComponentFixture<StockexchangeAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StockexchangeAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StockexchangeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
