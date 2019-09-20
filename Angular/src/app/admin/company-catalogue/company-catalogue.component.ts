import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CompanyService } from 'src/app/service/company.service';
import { Company } from 'src/app/models/company';

@Component({
  selector: 'app-list-company',
  templateUrl: './list-company.component.html',
  styleUrls: ['./list-company.component.css']
})
export class CompanyCatalogue implements OnInit {

  userId: number;
  companies: Company[];

  constructor(private router: Router, private companyService: CompanyService) { }

  ngOnInit() {
    let userId = localStorage.getItem("userId");
    this.userId = parseInt(userId);
    if (!userId) {
      alert("Logged out of your account, Please Login again")
      this.router.navigate(['login']);
      return;
    }
    this.companyService.getListOfCompanies().subscribe( async res => {
      this.companies = res;
    })
  }

}
