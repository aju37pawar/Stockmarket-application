import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignInComponent } from './common/sign-in/sign-in.component';
import { SignUpComponent } from './common/sign-up/sign-up.component';
import { AdminComponent } from './admin/admin/admin.component';
import { UpdateCompanyComponent } from './admin/update-company/update-company.component';
import { UpdateIpoComponent } from './admin/update-ipo/update-ipo.component';
import { UserComponent } from './user/user/user.component';
import { DetailsComponent } from './user/details/details.component';
import { DetailUpdateComponent } from './user/detail-update/detail-update.component';
import { IpoManagementComponent } from './user/ipo-management/ipo-management.component';
import { ComparisonDetailsComponent } from './user/comparison-details/comparison-details.component';
import { AddCompanyComponent } from './admin/company-add/company-add.component';
import { ListIpoComponent } from './admin/list-ipo/list-ipo.component';
import { CompanyCatalogue } from './admin/company-catalogue/company-catalogue.component';
import { StockexchangeCatalogue } from './admin/stockexchange-catalogue/stockexchange-catalogue.component';
import { UploadExcelComponent } from './admin/upload-excel/upload-excel.component';
import { StockExchangeAddComponent } from './admin/stockexchange-add/stockexchange-add.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: SignInComponent },
  { path: 'register', component: SignUpComponent },
  {
      path: 'admin', component: AdminComponent,
    children: [
      { path: '', component: UploadExcelComponent },
      { path: 'uploadexcel', component: UploadExcelComponent },
      { path: 'company-add', component: AddCompanyComponent },
      { path: 'companylist', component: CompanyCatalogue },
      { path: 'update-company/:id', component: UpdateCompanyComponent },
      { path: 'stockexchange-add', component: StockExchangeAddComponent },
      { path: 'stockexchange-list', component: StockexchangeCatalogue},
      { path: 'ipolist', component:  ListIpoComponent},
      { path: 'update-ipo/:id', component: UpdateIpoComponent }
    ]
  },
  {
    path: 'user', component: UserComponent,
    children: [
      { path: '', component: DetailsComponent },
      { path: 'details', component: DetailsComponent },
      { path: 'user-update', component: DetailUpdateComponent },
      { path: 'search', component: CompanyCatalogue },
      { path: 'ipomanage', component: IpoManagementComponent },
      { path: 'compare-details', component: ComparisonDetailsComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
