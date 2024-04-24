import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  pageEnCours = 'accueil';

  constructor(private router: Router) {}

  allerA(route: string) {
    this.router.navigate([route]); // 2ème manière de déclencher une route
  }
}
