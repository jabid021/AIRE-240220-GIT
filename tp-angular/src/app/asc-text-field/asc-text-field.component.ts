import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';

@Component({
  selector: 'asc-text-field',
  templateUrl: './asc-text-field.component.html',
  styleUrl: './asc-text-field.component.css'
})
export class AscTextFieldComponent implements OnInit, OnChanges {
  ngOnChanges(changes: SimpleChanges): void {
    console.log("chargement onChanges");
  }
  ngOnInit(): void {
    console.log("chargement oninit");
  }
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
