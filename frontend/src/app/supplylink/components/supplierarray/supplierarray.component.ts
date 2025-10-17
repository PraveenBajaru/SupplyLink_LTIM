import { Component } from '@angular/core';
import { Supplier } from '../../types/Supplier';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-supplierrarray',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './supplierarray.component.html',
  styleUrls: ['./supplierarray.component.css']
})
export class SupplierArrayComponent {
  supplierList: Supplier[]=[
    {
    supplierId:1,
  supplierName:'Jessica Alba',
  email:'jessica@gmail.com',
  phone:'8309751597',
  address:'kunchanpalli',
  username:'praveen',
  password:'praveen07',
  role:'cse',
  displayInfo() {
  }
  },{
    supplierId:2,
  supplierName:'John Wane',
  email:'johnwane@gmail.com',
  phone:'8309751598',
  address:'Guntu',
  username:'john',
  password:'john07',
  role:'software',
  displayInfo() {
  }
  },
  {
    supplierId:2,
  supplierName:'Kristan',
  email:'kristan@gmail.com',
  phone:'8309787598',
  address:'Vizag',
  username:'krsit',
  password:'krist07',
  role:'software',
  displayInfo() {
  }
  }

];
}
