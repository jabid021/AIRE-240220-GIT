import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../../../models/product';
import { ProductService } from '../../../services/product.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-list',
  standalone: true,
  imports: [ CommonModule ],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent {
  products$!: Observable<Product[]>;
  
  constructor(private service: ProductService) {

  }

  ngOnInit(): void {
    this.products$ = this.service.findAll();
  }
}
