import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ChartsModule } from 'ng2-charts';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListIpoComponent } from './admin/list-ipo/list-ipo.component';
import { UpdateCompanyComponent } from './admin/update-company/update-company.component';
import { UpdateIpoComponent } from './admin/update-ipo/update-ipo.component';
import { AdminComponent } from './admin/admin/admin.component';
import { ComparisonChartsComponent } from './user/comparison-charts/comparison-charts.component';
import { ComparisonDetailsComponent } from './user/comparison-details/comparison-details.component';
import { IpoManagementComponent } from './user/ipo-management/ipo-management.component';
import { DetailsComponent } from './user/details/details.component';
import { DetailUpdateComponent } from './user/detail-update/detail-update.component';
import { UserComponent } from './user/user/user.component';
import { FooterComponent } from './common/footer/footer.component';
import { HeaderComponent } from './common/header/header.component';
import { SignInComponent } from './common/sign-in/sign-in.component';
import { SignUpComponent } from './common/sign-up/sign-up.component';
import { AddCompanyComponent } from './admin/company-add/company-add.component';
import { CompanyCatalogue } from './admin/company-catalogue/company-catalogue.component';
import { StockexchangeCatalogue } from './admin/stockexchange-catalogue/stockexchange-catalogue.component';
import { UploadExcelComponent } from './admin/upload-excel/upload-excel.component';
import { StockExchangeAddComponent } from './admin/stockexchange-add/stockexchange-add.component';

@NgModule({
  declarations: [
    AppComponent,
    AddCompanyComponent,
    StockExchangeAddComponent,
    ListIpoComponent,
    CompanyCatalogue,
    UpdateCompanyComponent,
    UpdateIpoComponent,
    UploadExcelComponent,
    AdminComponent,
    ComparisonChartsComponent,
    ComparisonDetailsComponent,
    IpoManagementComponent,
    DetailsComponent,
    DetailUpdateComponent,
    UserComponent,
    FooterComponent,
    HeaderComponent,
    SignInComponent,
    SignUpComponent,
    StockexchangeCatalogue
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ChartsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
