import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { AuthInterceptor } from './interceptors/auth.interceptor';

import { HTTP_INTERCEPTORS, provideHttpClient, withFetch, withInterceptorsFromDi } from '@angular/common/http';
import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideHttpClient(
      withFetch(),
      withInterceptorsFromDi() // ou, au lieu de withInterceptorsFromDi() -> withInterceptors()
      // withInterceptors([ authInterceptor ]) // A utiliser si HttpInterceptorFn au lieu d'une classe qui implémente HttpInterceptor comme dans ce code
    ),

    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true } // Inutile dans le cas de withInterceptors()
  ]
};
