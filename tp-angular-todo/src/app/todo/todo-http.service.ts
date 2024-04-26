import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Todo } from '../model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodoHttpService {

  private todos: Todo[] = new Array<Todo>();

  constructor(private http: HttpClient) {
    this.load();
  }

  load() {
    let obs: Observable<Todo[]> = this.http.get<Todo[]>("http://localhost:8080/api/todo");
    
    obs.subscribe(resp => {
      this.todos = resp;
    });
  }

  loadByTitle(title: string ) {
    if(title) {
      this.http.get<Todo[]>("http://localhost:8080/api/todo/by-title/"+title).subscribe(resp => {
        this.todos = resp;
      });
    } else {
      this.load();
    }
  }

  findAll(): Todo[] {
    return this.todos;
  }

  findById(id?: number): Observable<Todo> {
    return this.http.get<Todo>("http://localhost:8080/api/todo/"+id);
  }

  create(todo: Todo): void {
    this.http.post<Todo>("http://localhost:8080/api/todo", todo).subscribe(resp => {
      this.load();
    });
  }

  update(todo: Todo): void {
    this.http.put<Todo>("http://localhost:8080/api/todo/"+todo.id, todo).subscribe(resp => {
      this.load();
    });
  }

  delete(id?: number): void {
    this.http.delete<void>("http://localhost:8080/api/todo/"+id).subscribe(resp => {
      this.load();
    });
  }
}
