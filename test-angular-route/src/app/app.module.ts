import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccueilComponent } from './accueil/accueil.component';
import { CoursComponent } from './cours/cours.component';
import { FormateurComponent } from './formateur/formateur.component';

@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent,
    CoursComponent,
    FormateurComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
