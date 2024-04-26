import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { TodoComponent } from './todo/todo.component';
import { TodoDetailComponent } from './todo-detail/todo-detail.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { TodoStatePipe } from './todo-state.pipe';
import { FormsModule } from '@angular/forms';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { BooleanPipe } from './boolean.pipe';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TodoComponent,
    TodoDetailComponent,
    PageNotFoundComponent,
    TodoStatePipe,
    UtilisateurComponent,
    BooleanPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
