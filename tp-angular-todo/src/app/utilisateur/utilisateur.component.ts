import { Component } from '@angular/core';
import { Utilisateur } from '../model';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrl: './utilisateur.component.css'
})
export class UtilisateurComponent {
  utilisateurs: Array<Utilisateur> = new Array<Utilisateur>();

  utilisateurForm?: Utilisateur = undefined;

  constructor() {
    this.utilisateurs.push(new Utilisateur(2, "AZID", "Hana", "hazid", "123456", false));
    this.utilisateurs.push(new Utilisateur(5, "BARDOU", "Hedieh", "hbardou", "123456", false));
    this.utilisateurs.push(new Utilisateur(6, "SAMY", "Marie Antoine", "msamy", "123456", true));
    this.utilisateurs.push(new Utilisateur(8, "SULTAN", "Eric", "esultan", "123456", false));
  }

  edit(id?: number) {
    this.utilisateurForm = {...this.utilisateurs.find(u => u.id == id)};
  }

  add() {
    this.utilisateurForm = new Utilisateur();
  }

  save() {
    // elle va utiliser les informations synchronisées depuis le formulaire vers la variable utilisateurForm
    // si l'id est renseigné (modification), vous devez écraser la cellule (position) du tableau qui correspondent aux mêmes ID
    
    // sinon (création), vous devez rechercher l'id le plus grand du tableau afin d'affecter l'incrément de celui-ci dans le nouvel objet utilisateurForm
    // puis le rajouter dans le tableau
  }

  cancel() {
    this.utilisateurForm = undefined;
  }

  remove(id?: number) {
    // rechercher par l'id, la position de l'objet à supprimer 
    // effectuer la suppression sur le tableau avec la méthodse splice
  }
}
