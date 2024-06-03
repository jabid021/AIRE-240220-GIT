import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { take } from 'rxjs';
import { ProductService } from './../../../services/product.service';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [ CommonModule, FormsModule, ReactiveFormsModule ],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {
  createProductForm!: FormGroup;

  nameCtrl!: FormControl;
  priceCtrl!: FormControl;

  constructor(private formBuilder: FormBuilder, private service: ProductService, private router: Router) { }

  ngOnInit(): void {
    this.nameCtrl = this.formBuilder.control("", Validators.required);
    this.priceCtrl = this.formBuilder.control("", [ Validators.required, Validators.min(1) ]);

    this.createProductForm = this.formBuilder.group({
      name: this.nameCtrl,
      price: this.priceCtrl
    });
  }

  create() {
    this.service.create(this.createProductForm.value)
      .pipe(take(1)) // Permet de se désinscrire dès la valeur reçue
      .subscribe({
        complete: () => this.router.navigate( ['product' ]),
        error: () => alert('Zut ça ne fonctionne pas')
      });
  }
}
