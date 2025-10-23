import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators, AbstractControl } from "@angular/forms";
import { AuthService } from "../../services/auth.service";
import { HttpErrorResponse } from "@angular/common/http";

@Component({
    selector: "app-user",
    templateUrl: "./user.component.html",
    styleUrls: ["./user.component.scss"],
})
export class UserComponent implements OnInit {
    userForm: FormGroup;
    successMessage: string | null = null;
    errorMessage: string | null = null;

    constructor(
        private formBuilder: FormBuilder,
        private authService: AuthService
    ) {}

    ngOnInit(): void {
        this.userForm = this.formBuilder.group({
            username: ["", [Validators.required, this.noSpecialCharacters]],
            password: ["", [Validators.required, Validators.minLength(8), this.passwordComplexity]],
            role: ["", [Validators.required]],
            supplierName: ["", [Validators.required]],
            email: ["", [Validators.required, Validators.email]],
        });
    }

    private noSpecialCharacters(control: AbstractControl): { [key: string]: boolean } | null {
        const SPECIAL_CHARACTERS_REGEX = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]/;
        if (SPECIAL_CHARACTERS_REGEX.test(control.value)) {
            return { specialCharacters: true };
        }
        return null;
    }

    private passwordComplexity(control: AbstractControl): { [key: string]: boolean } | null {
        const PASSWORD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        if (!PASSWORD_REGEX.test(control.value)) {
            return { passwordComplexity: true };
        }
        return null;
    }

    onSubmit(): void {
        if (this.userForm.valid) {
            this.authService.createUser(this.userForm.value).subscribe({
                next: (response) => {
                    this.successMessage = "User created successfully";
                    this.userForm.reset();
                    setTimeout(()=>{
                        this.successMessage = "";
                    },2000)
                    this.errorMessage = "";
                },
                error: (error: HttpErrorResponse) => {
                    console.log(error);
                    if(error.status === 409 && error.error === "Username already exists"){
                        this.successMessage = "";
                        this.errorMessage = "Username already exists";
                    }else{
                    this.errorMessage = error.error ?? "Please fill the form correctly";
                    }
                }
                });
        } else {
            this.errorMessage = "Please fill the form correctly";
        }
    }
}