import { Injectable } from '@angular/core';
import {ApiService} from "./api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/internal/operators";

@Injectable({
  providedIn: 'root'
})
export class FirstentityService {

  private FIRSTENTITY_PATH = "/entity1";

  constructor(private apiService: ApiService) { }

  getAllPageable(page) : Observable<any>{
    return this.apiService.get(this.FIRSTENTITY_PATH+'/pagination',page).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          return {};
        }
      }
    ));
  }

  getAll(page) : Observable<any>{
    return this.apiService.get(this.FIRSTENTITY_PATH+'/pagination',page).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          return {};
        }
      }
    ));
  }
}
