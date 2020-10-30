import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import { HomePageComponent } from './home-page/home-page.component';
import { CustomerCreateComponent } from './customer/customer-create/customer-create.component';
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';
import { EmployeeComponent } from './employee/employee.component';
import { ContractComponent } from './contract/contract.component';
import { EmployeeEditComponent } from './employee/employee-edit/employee-edit.component';
import { ContractEditComponent } from './contract/contract-edit/contract-edit.component';
import { ContractCreateComponent } from './contract/contract-create/contract-create.component';
import {EmployeeCreateComponent} from "./employee/employee-create/employee-create.component";

@NgModule({
    declarations: [
        AppComponent,
        CustomerComponent,
        HomePageComponent,
        CustomerCreateComponent,
        CustomerEditComponent,
        EmployeeComponent,
        EmployeeCreateComponent,
        ContractComponent,
        EmployeeEditComponent,
        ContractEditComponent,
        ContractCreateComponent,
        EmployeeCreateComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
