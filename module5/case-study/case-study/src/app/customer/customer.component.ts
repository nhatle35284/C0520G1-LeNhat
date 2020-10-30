import { Component, OnInit } from '@angular/core';
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  // birth = '^\d{4}[\-\/\s]?((((0[13578])|(1[02]))[\-\/\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\-\/\s]?(([0-2][0-9])|(30)))|(02[\-\/\s]?[0-2][0-9]))$';
  birth :string
  customer:string;
  listCustomer: string[] = [];
  customerForm: FormGroup;
  customerName: string;
  checkForm = false;
  i: number;
  q: number;
  constructor() { }

  ngOnInit(): void {
  }

}
