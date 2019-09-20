import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { CompanyCatalogue } from './company-catalogue.component';


describe('CompanyListComponent', () => {
  let component: CompanyCatalogue;
  let fixture: ComponentFixture<CompanyCatalogue>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompanyCatalogue ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanyCatalogue);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
