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

  todos: Array<Todo> = new Array<Todo>();

  todoForm: Todo = new Todo();

  recherche: string = "";

  dtJour: Date = new Date();

  constructor() {
    this.todos.push(new Todo(6, "Faire le repassage", false));
    this.todos.push(new Todo(8, "Passer la tondeuse", true));
    this.todos.push(new Todo(9, "Aspirer", true));
  }

  resetPrenom() {
    this.prenom = "";
  }

  changePrenom(evt: any) {
    this.prenom = evt.target.value;
  }

  addTodo() {
    this.todos.push(this.todoForm);
    this.todoForm = new Todo();
  }

  search(): Array<Todo> {
    if(this.recherche) {
      return this.todos.filter(todo => todo.title?.includes(this.recherche));
    } else {
      return this.todos;
    }
  }

  maSortieDepuisHelloWorld(chaine: string) {
    console.log("dans l'app component : " + chaine);
  }

  maSortieDepuisHelloWorldBis(chaine: string) {
    console.log("dans l'app component Bis : " + chaine);
  }

}
