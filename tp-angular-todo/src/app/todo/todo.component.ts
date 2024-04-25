import { Component } from '@angular/core';
import { Todo } from '../model';
import { Router } from '@angular/router';
import { TodoService } from './todo.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css'
})
export class TodoComponent {
  recherche: string = "";

  todoForm?: Todo;

  constructor(private router: Router, private todoService: TodoService) {
  }

  save() {
    if(this.todoForm) {
      if(this.todoForm?.id) { // modification
        this.todoService.update(this.todoForm);
      } else { // création
        this.todoService.create(this.todoForm);
      }
    }

    this.todoForm = undefined;
  }

  search(): Array<Todo> {
    if(this.recherche) {
      return this.todoService.findAll().filter(todo => todo.title?.includes(this.recherche));
    } else {
      return this.todoService.findAll();
    }

    // if(this.recherche) {
    //   let todosCopy: Array<Todo> = new Array<Todo>();
    //   for(let todo of this.todoService.findAll()) {
    //     if(todo.title?.includes(this.recherche)) {
    //       todosCopy.push(todo);
    //     }
    //   }
    // } else {
    //   return this.todoService.findAll();
    // }
  }

  goToDetail(id?: number) {
    this.router.navigate(['/todo', id]);
  }

  add() {
    this.todoForm = new Todo();
  }

  edit(id?: number) {
    this.todoForm = {...this.todoService.findById(id)};
  }

  remove(id?: number) {
    this.todoService.delete(id);
  }

  cancel() {
    this.todoForm = undefined;
  }

}
