import { Component, EventEmitter, HostListener, Input, Output } from '@angular/core';

@Component({
  selector: 'hello-world, [hello-world]',
  templateUrl: './hello-world.component.html',
  styleUrl: './hello-world.component.css'
})
export class HelloWorldComponent {

  @Input("texteAfficher")
  texteRecuEnAttribut?: string;

  @Input()
  donnee?: string;

  @Output("sortie")
  monOutput = new EventEmitter<string>();

  @HostListener("mouseenter")
  showAlert() {
    console.log("Je passe au dessus du fieldset");
  }

  @HostListener("mouseleave")
  hideAlert() {
    console.log("Je sors du fieldset");
  }

  clickButton() {
    this.monOutput.emit("texte qui vient depuis le composant Hello World");
  }


}
