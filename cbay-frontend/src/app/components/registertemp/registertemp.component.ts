import { Component } from '@angular/core';
@Component({
  selector: 'app-registertemp',
  templateUrl: './registertemp.component.html',
  styleUrls: ['./registertemp.component.css']
})
export class RegistertempComponent {

  clientType = ['buyer', 'seller',
    'moderator'];

  passwords_dont_match = false;

  model = new Client('', '', this.clientType[0],  '',
    '', '', '','');

  submitted = false;

  onSubmit() {
    if(this.model.password && this.model.password == this.model.confirm_password){
      this.submitted = true;
    }else{
      this.passwords_dont_match = true;
    }
  }

  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }

  reset() {
    this.model = new Client('', '', this.clientType[0],  '',
      '', '', '','' );
    this.passwords_dont_match = false;
  }
}

export class Client {

  constructor(
    public firstName: string,
    public lastName: string,
    public userType: string,
    public userName: string,
    public password: string,
    public confirm_password:string,
    public email: string,
    public Description: string
  ) {  }

}
