import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-registertemp',
  templateUrl: './registertemp.component.html',
  styleUrls: ['./registertemp.component.css']
})
export class RegistertempComponent {

  constructor(public http: HttpClient){}

  clientType = ['buyer', 'seller',
    'moderator'];

  clientModel: Client;

  passwords_dont_match = false;

  model = new Client('', '', this.clientType[0],  '',
    '', '', '','');

  submitted = false;

  onSubmit() {
    if(this.model.password && this.model.password == this.model.confirm_password){
      this.submitted = false;
      console.log(this.model.password + ' ' + this.model.userType + ' ' + this.model.email + ' '
        + this.model.userName + ' ' + this.model.lastName + ' ' + this.model.firstName);

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
