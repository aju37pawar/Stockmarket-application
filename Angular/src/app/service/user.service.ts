import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = 'http://localhost:8991/user';
  
  constructor(private http: HttpClient) { }

  getUsers(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}`);
  }

  registerUser(user: User): Observable<any> {
    return this.http.post(`${this.baseUrl}`, user);
  }

  updateUser(user: User): Observable<any> {
    return this.http.post(`${this.baseUrl}/edit`, user);
  }
}
