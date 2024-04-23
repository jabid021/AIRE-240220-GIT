import { Component } from '@angular/core';
import { Todo } from './todo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  prenom = "Eric";
  couleur = "#000000"
  todo: Todo = new Todo(4, "mon todo example", false);

  resetPrenom() {
    this.prenom = "";
  }

  changePrenom(evt: any) {
    this.prenom = evt.target.value;
  }

}
