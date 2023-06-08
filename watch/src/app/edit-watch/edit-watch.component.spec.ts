import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditWatchComponent } from './edit-watch.component';

describe('EditWatchComponent', () => {
  let component: EditWatchComponent;
  let fixture: ComponentFixture<EditWatchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditWatchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditWatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
