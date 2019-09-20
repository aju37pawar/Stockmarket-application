import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Company } from '../models/company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  baseUrl = 'http://localhost:8992/company';
  
  constructor(private http: HttpClient) { }

  getListOfCompanies(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}`);
  }

  addCompany(company: Company): Observable<any> {
    return this.http.post(`${this.baseUrl}`, company);
  }
}
