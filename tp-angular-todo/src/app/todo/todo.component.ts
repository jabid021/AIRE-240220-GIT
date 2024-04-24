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

  todoForm: Todo = new Todo();

  constructor(private router: Router) {
    this.todos.push(new Todo(6, "Faire le repassage", false));
    this.todos.push(new Todo(8, "Passer la tondeuse", true));
    this.todos.push(new Todo(9, "Aspirer", true));
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

  goToDetail(id?: number) {
    this.router.navigate(['/todo', id]);
  }

}
