import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { CoursComponent } from './cours/cours.component';
import { FormateurComponent } from './formateur/formateur.component';

const routes: Routes = [
  {path: "home", component: AccueilComponent},
  {path: "cours", component: CoursComponent},
  {path: "cours/:nom", component: CoursComponent},
  {path: "formateur", component: FormateurComponent},
  {path: "", redirectTo: "home", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
