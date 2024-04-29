import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UtilisateurHttpService } from '../utilisateur/utilisateur-http.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrl: './inscription.component.css'
})
export class InscriptionComponent {
  inscriptionForm!: FormGroup;

  nomCtrl!: FormControl;
  prenomCtrl!: FormControl;
  usernameCtrl!: FormControl;
  passwordCtrl!: FormControl;
  confirmPasswordCtrl!: FormControl;

  constructor(private utilisateurHttpService: UtilisateurHttpService, private formBuilder: FormBuilder, private router: Router) {

  }

  ngOnInit(): void {
    // const checkPasswords = (source: string, target: string) : ValidatorFn => {
    //   return (control: AbstractControl): ValidationErrors | null => {
    //     const sourceCtrl = control.get(source);
    //     const targetCtrl = control.get(target);
  
    //     return sourceCtrl && targetCtrl && sourceCtrl.value !== targetCtrl.value
    //       ? { mismatch: true }
    //       : null;
    //   };
    // }

    this.nomCtrl = this.formBuilder.control("", Validators.required);
    this.prenomCtrl = this.formBuilder.control("", Validators.required);
    this.usernameCtrl = this.formBuilder.control("", [Validators.required, Validators.minLength(4)]);
    this.passwordCtrl = this.formBuilder.control("", [Validators.required, Validators.minLength(5)]);
    this.confirmPasswordCtrl = this.formBuilder.control("");

    this.inscriptionForm = this.formBuilder.group({
      nom: this.nomCtrl,
      prenom: this.prenomCtrl,
      username: this.usernameCtrl,
      password: this.passwordCtrl,
      confirmPassword: this.confirmPasswordCtrl
    }
  );

  }

  inscription() {
    this.utilisateurHttpService.inscription(this.inscriptionForm.value).subscribe(() =>
      this.router.navigate(['/login'])
    );
  }

  
}
export class CustomValidators {
  static MatchValidator(source: string, target: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const sourceCtrl = control.get(source);
      const targetCtrl = control.get(target);

      return sourceCtrl && targetCtrl && sourceCtrl.value !== targetCtrl.value
        ? { mismatch: true }
        : null;
    };
  }
}