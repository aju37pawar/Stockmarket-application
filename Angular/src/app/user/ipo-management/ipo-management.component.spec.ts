import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IpoManagementComponent } from './ipo-management.component';

describe('IpoManagementComponent', () => {
  let component: IpoManagementComponent;
  let fixture: ComponentFixture<IpoManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IpoManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IpoManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
