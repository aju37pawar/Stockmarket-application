import { Component, OnInit } from '@angular/core';
import { IpoService } from 'src/app/service/ipo.service';
import { Router } from '@angular/router';
import { Ipo } from 'src/app/models/ipo';

@Component({
  selector: 'app-list-ipo',
  templateUrl: './list-ipo.component.html',
  styleUrls: ['./list-ipo.component.css']
})
export class ListIpoComponent implements OnInit {

  userId: number;
  ipos: Ipo[];

  constructor(private router: Router, private ipoService: IpoService) { }

  ngOnInit() {
    let userId = localStorage.getItem("userId");
    this.userId = parseInt(userId);
    if (!userId) {
      alert("Logged out of your account, Please Login again")
      this.router.navigate(['login']);
      return;
    }
    this.ipoService.getListOfIpos().subscribe(async res => {
      this.ipos = await res;
      console.log(this.ipos);
    })
  }

}
