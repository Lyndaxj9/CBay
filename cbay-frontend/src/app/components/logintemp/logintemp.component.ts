import {Component} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-logintemp',
  templateUrl: './logintemp.component.html',
  styleUrls: ['./logintemp.component.css']
})
export class LogintempComponent {

  constructor(public http: HttpClient, public router: Router) {
  }

<<<<<<< HEAD
  model = new Client('', '', '');
  submitted = false;
  server_error = false;
  unauthenticated = false;
  url = 'http://54.213.131.230:8089/CBay/rest/user/get/';
  clientType = ['buyer', 'seller',
    'moderator'];
=======
    model = new Client('', '', '');
    submitted = false;
    unauthenticated = false;
    url = 'http://54.213.131.230:8089/CBay/rest/user/get/';
    clientType = ['buyer', 'seller',
    'moderator', 'admin'];
>>>>>>> a5301351e5619a3d760b0b0a06ab6d3c14d40be6

  onSubmit() {
    this.submitted = false;
    this.get_user_data().then(response => {
      try {
        let id = response;
        if (Number.isInteger(id)) {
          sessionStorage.setItem('userid', id);
          this.router.navigateByUrl('/profile').catch(error=>{
            this.server_error = true;
            console.log(error);
          });
        }
        else {
          this.unauthenticated = true;
        }
      }
      catch (ex) {
        this.unauthenticated = true;
        console.log(ex);
      }
    });
  }

  // TODO: Remove this when we're done
  get diagnostic() {
    return JSON.stringify(this.model);
  }

  reset() {
    this.model = new Client('', '', '');
  }

  get_user_data(): Promise<any> {
    return this.http.get(this.url + this.model.userName + '/' + this.model.password + '/' + this.model.type)
      .toPromise();
  }
}

export class Client {

  constructor(public userName: string,
              public password: string,
              public type: string) {
  }

}
