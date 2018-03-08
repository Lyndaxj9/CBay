import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-additem',
  templateUrl: './additem.component.html',
  styleUrls: ['./additem.component.css']
})
export class AdditemComponent{

  model = new Item('', '', 0);

  submitted = false;

  onSubmit() {
      this.submitted = true;
  }

  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }

  reset() {
    this.model = new Item('', '', 0);
  }

}

export class Item {

  constructor(
    public name: string,
    public description: string,
    public price: number
  ) {  }

}
