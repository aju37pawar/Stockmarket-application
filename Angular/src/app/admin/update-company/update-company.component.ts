import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { Company } from 'src/app/models/company';
import { StockExchange } from 'src/app/models/stock-exchange';
import { Sector } from 'src/app/models/sector';
import { Router, ActivatedRoute } from '@angular/router';
import { StockExchangeService } from 'src/app/service/stock-exchange.service';
import { CompanyService } from 'src/app/service/company.service';

@Component({
  selector: 'update-company',
  templateUrl: './update-company.component.html',
  styleUrls: ['./update-company.component.css']
})
export class UpdateCompanyComponent implements OnInit {

  userId: number;
  company: Company = new Company('','','','','','','');
  id: number;
  stockExchanges: StockExchange[];
  sectors: Sector[];

  constructor(private router: Router, private _location: Location, private companyService: CompanyService,
     private stockExchangeService: StockExchangeService, private _route: ActivatedRoute) { }

  ngOnInit() {
    let userId = localStorage.getItem("userId");
    this.userId = parseInt(userId);
    if (!userId) {
      alert("Logged out of your account, Please Login again")
      this.router.navigate(['login']);
      return;
    }

    this._route.params.subscribe(res => {
      this.id = Number.parseInt(res['id'])
      console.log(this.id);
    });

    this.stockExchangeService.getListOfStockExhanges().subscribe(async res => {
      this.stockExchanges = await res;
      console.log(this.stockExchanges);
    });
  }

  onSubmit() {
    console.log(this.company);
  }

  backClicked() {
    this._location.back();
  }
}
