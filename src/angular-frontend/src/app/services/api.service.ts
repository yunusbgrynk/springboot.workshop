import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";
import {environment} from "../../environments/environment";
import 'rxjs/add/observable/of';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http:HttpClient){ }

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };



  get(path:string, params:HttpParams=new HttpParams()):Observable<any>{
    return this.http.get(path, {params}).pipe(
      catchError(this.formatError)
    );
  }

  post(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.post(environment.API_BASE_PATH + path, JSON.stringify(params), this.httpOptions).pipe(catchError(this.formatError));

  }

  put(){

  }

  delete(){

  }

  private formatError(error: any) {
    return Observable.of(environment.API_BASE_PATH + error.error);
  }
}