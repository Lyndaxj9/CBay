import { Component } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
    selector: 'app-logintemp',
    templateUrl: './logintemp.component.html',
    styleUrls: ['./logintemp.component.css']
})
export class LogintempComponent {

  constructor(public http: HttpClient, public router: Router) { }

    model = new Client('', '', '');
    submitted = false;
    unauthenticated = false;
    url = 'http://54.213.131.230:8089/CBay/rest/user/get/';
    clientType = ['buyer', 'seller',
    'moderator'];

    onSubmit() {
        this.submitted = false;
      this.get_user_data().then(response => {
        let id = response;
        if(Number.isInteger(id)){
          sessionStorage.setItem('userid', id);
          this.router.navigateByUrl('/profile');
        }else{
          this.unauthenticated = true;
        }
      });
<<<<<<< HEAD
=======
        this.submitted = true;
        sessionStorage.setItem('userid', '10000');
        sessionStorage.setItem('usertype', 'Seller');
        this.router.navigate(['/profile', sessionStorage.getItem('userid')]);
>>>>>>> a38d7a52d35e0e11bff76375cb64a64c4c7d6c0d
    }

    // TODO: Remove this when we're done
    get diagnostic() { return JSON.stringify(this.model); }

    reset() {
        this.model = new Client('', '', '');
    }

  get_user_data(): Promise<any> {
    return this.http.get(this.url + this.model.userName + '/' + this.model.password + '/' + this.model.type)
      .toPromise();
  }
}

export class Client {

    constructor(
    public userName: string,
     public password: string,
    public type: string
    ) {  }

}
