import { Component, Input } from '@angular/core';

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

  changeValue(val: string) {
    this.value = val;

    
  }
}
