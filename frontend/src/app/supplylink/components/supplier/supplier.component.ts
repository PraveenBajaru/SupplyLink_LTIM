import { Component, OnInit } from "@angular/core";
import { FormBuilder,FormGroup,Validators } from "@angular/forms";

@Component({
    selector: 'app-supplier',
    templateUrl: './supplier.component.html',
    //styleUrls: ['./supplier.component.css'] 
  })
export class SupplierComponent  implements OnInit{
    supplierForm: any;
    constructor(private fb:FormBuilder){}
ngOnInit(): void{
this.supplierForm=this.fb.group({
    name:['',Validators.required],
    email:['',[Validators.required,Validators.email]],
    username:['',Validators.required],
    password:['',Validators.required]
});
}
 
}
