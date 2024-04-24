import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'cours',
  templateUrl: './cours.component.html',
  styleUrl: './cours.component.css'
})
export class CoursComponent {

  nomCours!: string

  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe(params => this.nomCours = params['nom']);

  }

}
