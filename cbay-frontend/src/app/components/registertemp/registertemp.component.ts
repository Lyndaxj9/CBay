import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Router} from '@angular/router';
import { Url } from '../../shared/models/Url';

@Component({
    selector: 'app-registertemp',
    templateUrl: './registertemp.component.html',
    styleUrls: ['./registertemp.component.css']
})
export class RegistertempComponent {

    constructor(public http: HttpClient, public router: Router){}

    clientType = ['buyer', 'seller',
                  'moderator'];

    clientModel: Client;
    urlBase = new Url();
    url = this.urlBase.get_urlbase() + '/user/post';

    server_error = false;

    passwords_dont_match = false;

    model = new Client('', '', this.clientType[0],  '',
                       '', '', '','');

    submitted = false;

    onSubmit() {
        this.submitted = false;
        if(this.model.password && this.model.password == this.model.confirm_password){
            this.submitted = false;
            console.log(this.model.password + ' ' + this.model.userType + ' ' + this.model.email + ' '
                        + this.model.userName + ' ' + this.model.lastName + ' ' + this.model.firstName);
            this.register().then(response=>{
                try {
                    const id = response;
                    if (Number.isInteger(id)) {
                        sessionStorage.setItem('userid', id);
                        sessionStorage.setItem('usertype', this.model.userType);
                        this.router.navigate(['/profile', id]).catch(error=>{
                            this.server_error = true;
                            console.log(error);
                        });
                    }
                }
                catch (ex) {
                    console.log(ex);
                    this.server_error = true;
                }
            });

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

    register():Promise<any>{
        return this.http.post(this.url, {
            type:this.model.userType,
            firstname:this.model.firstName,
            lastname:this.model.lastName,
            username:this.model.userName,
            pw:this.model.password,
            email:this.model.email
        }).toPromise();
    }
}

export class Client {

    constructor(
    public firstName: string,
     public lastName: string,
     public userType: string,
     public userName: string,
     public password: string,
     public confirm_password: string,
     public email: string,
     public Description: string
    ) {  }

}
