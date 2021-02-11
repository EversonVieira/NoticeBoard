import { ChangeDetectorRef, Component, Input, OnInit, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import * as moment from 'moment';
import { Notice } from '../../models/notice';
import { NoticeService } from '../../services/notice-service.service'

@Component({
  selector: 'app-notice-row',
  templateUrl: './notice-row.component.html',
  styleUrls: ['./notice-row.component.sass']
})
export class NoticeRowComponent implements OnInit {

  notice: any = {};
  viewDate: any = ''
  publishDate: any = ''
  isOpen: Boolean = false;
  @Input() outsideNotice?: Notice = undefined
  @Output() rebase = new EventEmitter();
  constructor(private noticeService: NoticeService) {
  }

  ngOnInit(): void {
    this.notice = this.outsideNotice;

    this.publishDate = moment(this.notice.publishDate).toDate();
    this.viewDate = !!this.notice.viewDate ? moment(this.notice.viewDate).toDate() : this.viewDate;

  }
  setOpenState() {
    this.isOpen = !this.isOpen;
    this.sendViewUpdate();
  }
  sendViewUpdate() {
    if (!this.notice.viewDate) {
      if (!!this.notice) {
        this.noticeService.update(this.notice).subscribe(response => {
          if (response) {
            this.get();
          }
        },error =>{
          alert(`Failed because: ${error.toString()}`);
        })
      }
      else {
        alert("Notice doesn't have a value");
      }
    }
  }
  get() {
    if (!!this.notice) {
      if (!this.notice.viewDate) {
        this.noticeService.getById(this.notice.id).subscribe(response => {
          this.notice = response;
          this.publishDate = moment(this.notice.publishDate).toDate();
          this.viewDate = !!this.notice.viewDate ? moment(this.notice.viewDate).toDate() : this.viewDate;
        },error =>{
          alert(`Failed because: ${error.toString()}`);
        })
      }
      else {
        alert("Notice doesn't have a value");
      }
    }
  }
  delete() {
    if (!!this.notice) {
      this.noticeService.delete(this.notice).subscribe(response => {
        if (response) {
          alert("Success!");
          this.rebase.emit("completed");
        }
      },error =>{
        alert(`Failed because: ${error.toString()}`);
      });
    }
    else {
      alert("Notice doesn't have a value");
    }
  }
  update() {
    if (!!this.notice) {
      this.noticeService.update(this.notice).subscribe(response => {
        if (response) {
          alert("Success!");
        }
      },error =>{
        alert(`{Failed because: ${error.toString()}`)
      })
    }
    else {
      alert("Notice doesn't have a value");
    }
  }

}
