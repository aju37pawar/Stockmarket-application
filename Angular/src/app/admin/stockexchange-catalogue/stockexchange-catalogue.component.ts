import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StockExchangeService } from 'src/app/service/stock-exchange.service';
import { StockExchange } from 'src/app/models/stock-exchange';

@Component({
  selector: 'app-stockexchange-catalogue',
  templateUrl: './stockexchange-catalogue.component.html',
  styleUrls: ['./stockexchange-catalogue.component.css']
})
export class StockexchangeCatalogue implements OnInit {

  userId: number;
  stockExchanges: StockExchange[];

  constructor(private router: Router, private stockExchangeService: StockExchangeService) { }

  ngOnInit() {
    let userId = localStorage.getItem("userId");
    this.userId = parseInt(userId);
    if (!userId) {
      alert("Logged out of your account, Please Login again")
      this.router.navigate(['login']);
      return;
    }
    this.stockExchangeService.getListOfStockExhanges().subscribe( async res => {
      this.stockExchanges = res;
    })
  }

}
