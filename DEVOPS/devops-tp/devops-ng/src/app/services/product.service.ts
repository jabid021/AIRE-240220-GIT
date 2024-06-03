import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private readonly ENDPOINT: string = `${ environment.API_ENDPOINT }/product`;
  
  constructor(private httpClient: HttpClient) { }

  public findAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.ENDPOINT);
  }

  public create(product: any): Observable<string> {
    return this.httpClient.post<string>(this.ENDPOINT, product);
  }
}
