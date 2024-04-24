import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { BackgroundBlackDirective } from './background-black.directive';
import { TodoStatePipe } from './todo-state.pipe';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { AscBoldComponent } from './asc-bold/asc-bold.component';
import { AscTextFieldComponent } from './asc-text-field/asc-text-field.component';
import { AscListComponent } from './asc-list/asc-list.component';

@NgModule({
  declarations: [
    AppComponent,
    BackgroundBlackDirective,
    TodoStatePipe,
    HelloWorldComponent,
    AscBoldComponent,
    AscTextFieldComponent,
    AscListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
