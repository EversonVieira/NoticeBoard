import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NoticeRowComponent } from './notice-row.component';

describe('NoticeRowComponent', () => {
  let component: NoticeRowComponent;
  let fixture: ComponentFixture<NoticeRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NoticeRowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NoticeRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
