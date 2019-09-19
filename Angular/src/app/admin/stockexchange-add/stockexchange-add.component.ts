import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'app-stockexchange-add',
  templateUrl: './stockexchange-add.component.html',
  styleUrls: ['./stockexchange-add.component.css']
})
export class StockexchangeAddComponent implements OnInit {

  constructor(private _location: Location) { }

  ngOnInit() {
  }

  backClicked() {
    this._location.back();
  }

}
