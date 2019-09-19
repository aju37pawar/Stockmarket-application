import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComparisonDetailsComponent } from './comparison-details.component';

describe('ComparisonDetailsComponent', () => {
  let component: ComparisonDetailsComponent;
  let fixture: ComponentFixture<ComparisonDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComparisonDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComparisonDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
