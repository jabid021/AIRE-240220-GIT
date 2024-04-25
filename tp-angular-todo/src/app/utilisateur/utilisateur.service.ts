import { Injectable } from '@angular/core';
import { Utilisateur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  utilisateurs: Array<Utilisateur> = new Array<Utilisateur>();

  constructor() {
    this.utilisateurs.push(new Utilisateur(2, "AZID", "Hana", "hazid", "123456", false));
    this.utilisateurs.push(new Utilisateur(5, "BARDOU", "Hedieh", "hbardou", "123456", false));
    this.utilisateurs.push(new Utilisateur(6, "SAMY", "Marie Antoine", "msamy", "123456", true));
    this.utilisateurs.push(new Utilisateur(8, "SULTAN", "Eric", "esultan", "123456", false));
  }

  findAll(): Array<Utilisateur> {
    return this.utilisateurs;
  }

  findById(id?: number): Utilisateur| undefined {
    return this.utilisateurs.find(t => t.id == id);
  }

  create(utilisateur: Utilisateur) {
    let max = 0;
    for(let t of this.utilisateurs) {
      if(t.id && t.id > max) {
        max = t.id;
      }
    }
    utilisateur.id = ++max;
    this.utilisateurs.push(utilisateur);
  }

  update(utilisateur: Utilisateur) {
    let position = this.utilisateurs.findIndex(t => t.id == utilisateur.id);

    this.utilisateurs[position] = utilisateur;
  }

  delete(id?: number) {
    let position = this.utilisateurs.findIndex(t => t.id == id);

    this.utilisateurs.splice(position, 1);
  }
}
