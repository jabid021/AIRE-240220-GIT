import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Todo } from '../model';
import { TodoService } from '../todo/todo.service';

@Component({
  selector: 'app-todo-detail',
  templateUrl: './todo-detail.component.html',
  styleUrl: './todo-detail.component.css'
})
export class TodoDetailComponent {
  id?: number;
  todoCurrent?: Todo;

  constructor(private route: ActivatedRoute, private todoService: TodoService) {
    this.route.params.subscribe((params) => {
      this.todoCurrent = this.todoService.findById(params['id']);

    });

    // this.route.params.subscribe(this.paramsRecus); // exemples avec une fonction nommée


   
  }

  paramsRecus(parametres: any) {
    this.todoCurrent = this.todoService.findById(parametres['id']);


    // for(let todo of this.todoService.findAll()) {
    //   if(todo.id == parametres['id']) {
    //     this.todoCurrent = todo;
    //     break;
    //   }
    // }


  }


}
