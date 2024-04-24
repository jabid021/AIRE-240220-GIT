import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'hello-world, [hello-world]',
  templateUrl: './hello-world.component.html',
  styleUrl: './hello-world.component.css'
})
export class HelloWorldComponent {

  @HostListener("mouseenter")
  showAlert() {
    console.log("Je passe au dessus du fieldset");
  }

  @HostListener("mouseleave")
  hideAlert() {
    console.log("Je sors du fieldset");
  }


}
