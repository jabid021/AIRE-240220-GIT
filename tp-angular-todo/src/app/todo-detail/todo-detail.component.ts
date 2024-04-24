import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Todo } from '../model';

@Component({
  selector: 'app-todo-detail',
  templateUrl: './todo-detail.component.html',
  styleUrl: './todo-detail.component.css'
})
export class TodoDetailComponent {
  id?: number;
  todoCurrent?: Todo;

  todos: Array<Todo> = new Array<Todo>();

  constructor(private route: ActivatedRoute) {
    this.todos.push(new Todo(6, "Faire le repassage", false));
    this.todos.push(new Todo(8, "Passer la tondeuse", true));
    this.todos.push(new Todo(9, "Aspirer", true));
    
    this.route.params.subscribe(params => this.todoCurrent = this.todos.find(t => t.id == params['id']));
  }
}
