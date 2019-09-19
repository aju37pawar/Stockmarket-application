import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StockexchangeAddComponent } from './admin/stockexchange-add/stockexchange-add.component';
import { ListIpoComponent } from './admin/list-ipo/list-ipo.component';
import { CompanyListComponent } from './admin/company-list/company-list.component';
import { UpdateCompanyComponent } from './admin/update-company/update-company.component';
import { UpdateIpoComponent } from './admin/update-ipo/update-ipo.component';
import { UploadExcelComponent } from './admin/upload-excel/upload-excel.component';
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
import { CompanyAddComponent } from './admin/company-add/company-add.component';

@NgModule({
  declarations: [
    AppComponent,
    CompanyAddComponent,
    StockexchangeAddComponent,
    ListIpoComponent,
    CompanyListComponent,
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
    SignUpComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
