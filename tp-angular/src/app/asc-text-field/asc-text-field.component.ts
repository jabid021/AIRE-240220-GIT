import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'asc-text-field',
  templateUrl: './asc-text-field.component.html',
  styleUrl: './asc-text-field.component.css'
})
export class AscTextFieldComponent {
  @Input()
  label?: string;

  @Input()
  value?: string;

  @Output()
  emetteur = new EventEmitter<string>();

  changeValue(val: string) {
    console.log("changeValue")
    this.value = val;
    this.emetteur.emit(val);

  }
}
