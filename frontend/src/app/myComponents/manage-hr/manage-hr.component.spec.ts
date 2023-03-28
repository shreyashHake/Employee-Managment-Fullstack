import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageHrComponent } from './manage-hr.component';

describe('ManageHrComponent', () => {
  let component: ManageHrComponent;
  let fixture: ComponentFixture<ManageHrComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManageHrComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManageHrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
