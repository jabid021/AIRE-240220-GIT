import { Component, HostListener, Input } from '@angular/core';

@Component({
  selector: 'asc-tooltip,[asc-tooltip]',
  templateUrl: './asc-tooltip.component.html',
  styleUrl: './asc-tooltip.component.css'
})
export class AscTooltipComponent {
  @Input("titre")
  titre!: string;

  visible: boolean = false;

  constructor() {
  }
 
  @HostListener("mouseenter")
  enter() {
    this.visible = true;
  }

  @HostListener("mouseleave")
  exit() {
    this.visible = false;
  }
}
