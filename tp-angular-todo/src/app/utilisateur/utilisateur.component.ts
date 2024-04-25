import { Component } from '@angular/core';
import { Utilisateur } from '../model';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrl: './utilisateur.component.css'
})
export class UtilisateurComponent {
  utilisateurs: Array<Utilisateur> = new Array<Utilisateur>();

  constructor() {
    this.utilisateurs.push(new Utilisateur(2, "AZID", "Hana", "hazid", "123456", false));
    this.utilisateurs.push(new Utilisateur(5, "BARDOU", "Hedieh", "hbardou", "123456", false));
    this.utilisateurs.push(new Utilisateur(6, "SAMY", "Marie Antoine", "msamy", "123456", true));
    this.utilisateurs.push(new Utilisateur(8, "SULTAN", "Eric", "esultan", "123456", false));
  }

  edit(id?: number) {

  }

  add() {

  }

  cancel() {
    
  }
}
