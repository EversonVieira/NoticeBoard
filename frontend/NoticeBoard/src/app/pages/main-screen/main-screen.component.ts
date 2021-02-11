import { Component, OnInit } from '@angular/core';
import {Notice} from './../../models/notice'
import {NoticeService} from './../../services/notice-service.service'

@Component({
  selector: 'app-main-screen',
  templateUrl: './main-screen.component.html',
  styleUrls: ['./main-screen.component.sass']
})
export class MainScreenComponent implements OnInit {
  
  globalNotice: Notice = new Notice();
  noticeList: any = [];
  blockGoForward: boolean = false
  currentpage = 1;

  constructor(private noticeService:NoticeService) { }

  ngOnInit(): void {
    this.noticeService.getList(this.currentpage).subscribe(response => {
      this.noticeList = response;
    });
  }
  goForward(){
    this.currentpage++;
    this.noticeService.getList(this.currentpage).subscribe(response => {
      this.noticeList = response;
      if(this.noticeList.length < 1){
        alert("No content to show");
        this.blockGoForward = true
        return;
      }
    });
  }
  goBack(){
    this.blockGoForward = false
    this.currentpage--;
    this.noticeService.getList(this.currentpage).subscribe(response => {
      this.noticeList = response;
    });
  }
  save(){
    if(!this.globalNotice.title){
      alert("Give a title to add a notice.");
      return;
    }
    if(!this.globalNotice.description){
      alert("Give a description to add a notice.");
      return;
    }

    this.noticeService.insert(this.globalNotice).subscribe(response=>{
      if (response){
        alert("Success!");

        this.noticeService.getList(this.currentpage).subscribe(response =>{
          this.noticeList = response;
        })
      }
    });

  }

}
