import { Component } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
    selector: 'app-logintemp',
    templateUrl: './logintemp.component.html',
    styleUrls: ['./logintemp.component.css']
})
export class LogintempComponent {

  model = new Client('', '');

  submitted = false;

  onSubmit() {
      this.submitted = true;
  }

  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }

  reset() {
    this.model = new Client('', '');
  }
}

export class Client {

  constructor(
    public userName: string,
    public password: string,
  ) {  }

}
