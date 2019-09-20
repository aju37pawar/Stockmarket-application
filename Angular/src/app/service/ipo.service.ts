import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ipo } from '../models/ipo';

@Injectable({
  providedIn: 'root'
})
export class IpoService {

  baseUrl = 'http://localhost:8992/ipo';

  constructor(private http: HttpClient) { }

  getListOfIpos(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}`);
  }

  addIpo(ipo: Ipo): Observable<any> {
    return this.http.post(`${this.baseUrl}`, ipo);
  }

  updateIpo(ipo: Ipo): Observable<any> {
    return this.http.post(`${this.baseUrl}`, ipo);
  }
}
