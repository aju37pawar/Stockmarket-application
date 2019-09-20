import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StockexchangeCatalogue } from './stockexchange-catalogue.component';

describe('StockexchangeListComponent', () => {
  let component: StockexchangeCatalogue;
  let fixture: ComponentFixture<StockexchangeCatalogue>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StockexchangeCatalogue ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StockexchangeCatalogue);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
