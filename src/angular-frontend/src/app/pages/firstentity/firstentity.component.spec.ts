import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FirstentityComponent } from './firstentity.component';

describe('FirstentityComponent', () => {
  let component: FirstentityComponent;
  let fixture: ComponentFixture<FirstentityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FirstentityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FirstentityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
