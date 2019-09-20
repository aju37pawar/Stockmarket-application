import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { Router } from '@angular/router';
import { Company } from 'src/app/models/company';
import { CompanyService } from 'src/app/service/company.service';
import { StockExchangeService } from 'src/app/service/stock-exchange.service';
import { StockExchange } from 'src/app/models/stock-exchange';
import { Sector } from 'src/app/models/sector';

@Component({
  selector: 'add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent implements OnInit {

  userId: number;
  company: Company = new Company('', '', '', '', '', '', '');
  stockExchanges: StockExchange[];
  sectors: Sector[];

  constructor(private router: Router, private _location: Location, private companyService: CompanyService,
   private stockExchangeService: StockExchangeService) { }

  ngOnInit() {
    let userId = localStorage.getItem("userId");
    this.userId = parseInt(userId);
    if (!userId) {
      alert("Logged out of your account, Please Login again")
      this.router.navigate(['login']);
      return;
    }
    
    this.stockExchangeService.getListOfStockExhanges().subscribe(async res => {
      this.stockExchanges = await res;
      console.log(this.stockExchanges);
    });
  }

  onSubmit() {
    console.log(this.company);
    this.companyService.addCompany(this.company).subscribe(
      async res => {
        this.company = await res;
        console.log(this.company);
        this.router.navigate(['admin/companylist']);
      },
      error => console.log(error)
    );
  }

  backClicked() {
    this._location.back();
  }
}
