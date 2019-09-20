import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { Router } from '@angular/router';
import { StockExchangeService } from 'src/app/service/stock-exchange.service';
import { StockExchange } from 'src/app/models/stock-exchange';

@Component({
  selector: 'stockexchange-add',
  templateUrl: './stockexchange-add.component.html',
  styleUrls: ['./stockexchange-add.component.css']
})
export class StockExchangeAddComponent implements OnInit {

  userId: number;
  stockExchange: StockExchange = new StockExchange('', '', '');

  constructor(private router: Router, private _location: Location, private stockExchangeService: StockExchangeService) { }

  ngOnInit() {
    let userId = localStorage.getItem("userId");
    this.userId = parseInt(userId);
    if (!userId) {
      alert("Logged out of your account, Please Login again")
      this.router.navigate(['login']);
      return;
    }
  }

  onSubmit() {
    console.log(this.stockExchange);
    this.stockExchangeService.addStockExhange(this.stockExchange).subscribe(
      async res => {
        this.stockExchange = await res;
        console.log(this.stockExchange);
        this.router.navigate(['admin/stockexchange-list']);
      },
      error => console.log(error)
    );
  }

  backClicked() {
    this._location.back();
  }

}
