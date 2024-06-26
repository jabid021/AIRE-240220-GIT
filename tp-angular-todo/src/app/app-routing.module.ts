import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TodoComponent } from './todo/todo.component';
import { TodoDetailComponent } from './todo-detail/todo-detail.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { ListeComponent } from './liste/liste.component';
import { LoginComponent } from './login/login.component';
import { InscriptionComponent } from './inscription/inscription.component';

const routes: Routes = [
  {path: "home", component: HomeComponent},
  {path: "inscription", component: InscriptionComponent},
  {path: "liste", component: ListeComponent},
  {path: "login", component: LoginComponent},
  {path: "todo", component: TodoComponent},
  {path: "todo/:id", component: TodoDetailComponent},
  {path: "utilisateur", component: UtilisateurComponent},
  {path: "", redirectTo: "home", pathMatch: "full"},
  {path: "**", component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
