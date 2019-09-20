import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StockPrice } from '../models/stock-price';

@Injectable({
  providedIn: 'root'
})
export class StockPriceService {

  baseUrl = 'http://localhost:8992/stockprice';

  constructor(private http: HttpClient) { }

  getStockPrices(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}`);
  }
}
