import { Component } from '@angular/core';
import { Todo } from '../model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css'
})
export class TodoComponent {
  recherche: string = "";

  todos: Array<Todo> = new Array<Todo>();

  todoForm?: Todo;

  constructor(private router: Router) {
    this.todos.push(new Todo(6, "Faire le repassage", false));
    this.todos.push(new Todo(8, "Passer la tondeuse", true));
    this.todos.push(new Todo(9, "Aspirer", true));
  }

  save() {
    if(this.todoForm) {
      if(this.todoForm?.id) { // modification
        let position = this.todos.findIndex(t => t.id == this.todoForm?.id);

        this.todos[position] = this.todoForm;
      } else { // création
        let max = 0;
        for(let t of this.todos) {
          if(t.id && t.id > max) {
            max = t.id;
          }
        }
        this.todoForm.id = ++max;
        this.todos.push(this.todoForm);
      }
    }

    this.todoForm = undefined;
  }

  search(): Array<Todo> {
    if(this.recherche) {
      return this.todos.filter(todo => todo.title?.includes(this.recherche));
    } else {
      return this.todos;
    }

    // if(this.recherche) {
    //   let todosCopy: Array<Todo> = new Array<Todo>();
    //   for(let todo of this.todos) {
    //     if(todo.title?.includes(this.recherche)) {
    //       todosCopy.push(todo);
    //     }
    //   }
    // } else {
    //   return this.todos;
    // }
  }

  goToDetail(id?: number) {
    this.router.navigate(['/todo', id]);
  }

  add() {
    this.todoForm = new Todo();
  }

  edit(id?: number) {
    this.todoForm = {...this.todos.find(t => t.id == id)};
  }

  remove(id?: number) {
    let position = this.todos.findIndex(t => t.id == id);

    let positionAlt;
    for(let i=0;i<this.todos.length;i++) {
      if(this.todos[i] == id) {
        positionAlt = i;
        break;
      }
    }

    this.todos.splice(position, 1); // argument 1 (position): début de la suppression - argument 2 (1) : nombre d'éléments à supprimer
  }

  cancel() {
    this.todoForm = undefined;
  }

}
