import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[bg-black]'
})
export class BackgroundBlackDirective {

  constructor(private el: ElementRef, private renderer: Renderer2) {
    this.renderer.setStyle(this.el.nativeElement, 'background-color', 'black');
    this.renderer.setStyle(this.el.nativeElement, 'color', 'white');
   }

}
