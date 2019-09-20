import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StockExchange } from '../models/stock-exchange';

@Injectable({
  providedIn: 'root'
})
export class StockExchangeService {

  baseUrl = 'http://localhost:8992';

  constructor(private http: HttpClient) { }

  getListOfStockExhanges(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/stockExchange`);
  }

  addStockExhange(stockExhange: StockExchange): Observable<any> {
    return this.http.post(`${this.baseUrl}/stockExchange`, stockExhange);
  }
}
