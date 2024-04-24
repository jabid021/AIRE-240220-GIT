import { query } from '@angular/animations';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'formateur',
  templateUrl: './formateur.component.html',
  styleUrl: './formateur.component.css'
})
export class FormateurComponent {

  nom!: string;
  prenom!: string;

  constructor(private route: ActivatedRoute) {
    this.route.queryParams.subscribe(queryParams => {
      this.nom = queryParams["nom"];
      this.prenom = queryParams["prenom"];
    });
  }

}
