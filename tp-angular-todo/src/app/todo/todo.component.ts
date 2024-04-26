import { Component } from '@angular/core';
import { Todo } from '../model';
import { Router } from '@angular/router';
import { TodoService } from './todo.service';
import { TodoHttpService } from './todo-http.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css'
})
export class TodoComponent {
  recherche: string = "";

  todoForm?: Todo;

  constructor(private router: Router, private todoHttpService: TodoHttpService) {
  }

  save() {
    if(this.todoForm) {
      if(this.todoForm?.id) { // modification
        this.todoHttpService.update(this.todoForm);
      } else { // création
        this.todoHttpService.create(this.todoForm);
      }
    }

    this.todoForm = undefined;
  }

  search(): Array<Todo> {
    if(this.recherche) {
      return this.todoHttpService.findAll().filter(todo => todo.title?.includes(this.recherche));
    } else {
      return this.todoHttpService.findAll();
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
    this.todoHttpService.findById(id).subscribe(response => {
      this.todoForm = response;
    });
  }

  remove(id?: number) {
    this.todoHttpService.delete(id);
  }

  cancel() {
    this.todoForm = undefined;
  }

}
