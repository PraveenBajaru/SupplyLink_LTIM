import { Component, OnInit } from "@angular/core";
import { AbstractControl, FormBuilder,FormGroup,ValidationErrors,Validators } from "@angular/forms";

@Component({
    selector: 'app-supplier',
    templateUrl: './supplier.component.html',
    //styleUrls: ['./supplier.component.css'] 
  })
export class SupplierComponent  implements OnInit{
    supplierForm: any;
    constructor(private fb:FormBuilder){}

    ngOnInit(): void {
        this.supplierForm = this.fb.group({
          supplierName: ['', [Validators.required, this.noSpecialCharacters]],
          email: ['', [Validators.required, Validators.email]],
          phone: [''],
          address: [''],
          username: ['', [Validators.required, this.noSpecialCharacters]],
          password: ['', [Validators.required, Validators.minLength(8), this.passwordStrengthValidator]],
          role: ['', Validators.required]
        });
      }

      onSubmit(): void {
        if (this.supplierForm.valid) {
          console.log('Supplier Data:', this.supplierForm.value);
        } 
      }

      noSpecialCharacters(control: AbstractControl): ValidationErrors | null {
        const regex = /^[a-zA-Z0-9 ]*$/;
        return regex.test(control.value) ? null : { specialChars: true };
      }
    
      passwordStrengthValidator(control: AbstractControl): ValidationErrors | null {
        const value = control.value;
        const hasUpperCase = /[A-Z]/.test(value);
        const hasNumber = /\d/.test(value);
        return hasUpperCase && hasNumber ? null : { weakPassword: true };
      }
 
}
