import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const base64 = btoa(`${ this.authService.username }:${ this.authService.password }`);

    req = req.clone({
      setHeaders: {
        Authorization: `Basic ${ base64 }`
      }
    });

    return next.handle(req);
  }
};
