import {Component} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import { Url } from '../../shared/models/Url';

@Component({
  selector: 'app-logintemp',
  templateUrl: './logintemp.component.html',
  styleUrls: ['./logintemp.component.css']
})
export class LogintempComponent {

  constructor(public http: HttpClient, public router: Router) {
  }

  model = new Client('', '', '');
  submitted = false;
  server_error = false;
  unauthenticated = false;
  urlBase = new Url();
  url = this.urlBase.get_urlbase() + '/user/get/';
  clientType = ['buyer', 'seller',
    'moderator', 'admin'];

  onSubmit() {
    this.submitted = false;
    this.get_user_data().then(response => {
      try {
        const id = response;
        if (Number.isInteger(id)) {
            console.log('userid: ' + id);
            sessionStorage.setItem('userid', id);
            sessionStorage.setItem('usertype', this.model.type);
            this.router.navigate(['/profile', id])
                .catch(error => {
            this.server_error = true;
            console.log(error);
        });
        } else {
          this.unauthenticated = true;
        }
      } catch (ex) {
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
