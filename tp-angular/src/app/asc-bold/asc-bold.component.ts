import { Component, HostListener, OnInit } from '@angular/core';

@Component({
  selector: 'asc-bold',
  templateUrl: './asc-bold.component.html',
  styleUrl: './asc-bold.component.css'
})
export class AscBoldComponent {


  compteur: number = 0;

  @HostListener("click")
  maMethodeCliquer() {
    this.compteur++;
    console.log("compteur="+this.compteur);
  }

}
