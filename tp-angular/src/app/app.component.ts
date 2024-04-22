import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  prenom = "Eric";

  resetPrenom() {
    this.prenom = "";
  }

  changePrenom(evt: any) {
    this.prenom = evt.target.value;
  }

}
