import { Injectable } from '@angular/core';
import { HttpService} from '../core/http-service.service';
import { Notice} from '../models/notice';
@Injectable({
  providedIn: 'root'
})
export class NoticeService {

  private GET_ALL_URL:string = 'getall';
  private GET_BY_ID_URL:string = 'getbyid';
  private INSERT_URL:string = 'insert';
  private UPDATE_URL:string = 'update';
  private DELETE_URL:string = 'delete';
  private GET_LIST_URL:string = 'getlist';

  constructor(private HttpService: HttpService) {
   }

  getAll(){
    return this.HttpService.get(this.GET_ALL_URL);
  }
  getList(page:number){
    return this.HttpService.get(`${this.GET_LIST_URL}/${page - 1}`)
  }
  getById(id:number){
    return this.HttpService.get(`${this.GET_BY_ID_URL}/${id}`);
  }

  insert(notice:Notice){
    return this.HttpService.post(this.INSERT_URL,notice);
  }
  update(notice:Notice){
    return this.HttpService.patch(this.UPDATE_URL,notice);
  }
  delete(notice:Notice){
    return this.HttpService.delete(`${this.DELETE_URL}/${notice.id}`);
  }
}
