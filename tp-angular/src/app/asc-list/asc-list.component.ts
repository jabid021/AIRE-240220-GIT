import { Component, ContentChild, TemplateRef } from '@angular/core';

@Component({
  selector: 'asc-list',
  templateUrl: './asc-list.component.html',
  styleUrl: './asc-list.component.css'
})
export class AscListComponent {
  @ContentChild("contenuAInjecter")
  contenu!: TemplateRef<unknown>;

  @ContentChild("contenuAInjecterBis")
  contenuBis!: TemplateRef<unknown>;
}
