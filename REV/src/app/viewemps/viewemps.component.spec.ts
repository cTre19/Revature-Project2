import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewempsComponent } from './viewemps.component';

describe('ViewempsComponent', () => {
  let component: ViewempsComponent;
  let fixture: ComponentFixture<ViewempsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewempsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewempsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
