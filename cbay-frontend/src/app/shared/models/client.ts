import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Url } from './url';

export class Client {
    userid: number;
    firstname: string;
    lastname: string;
    usertype: string;
    username: string;
    password: string;
    email: string;
    rating: number;
    description: string;
    user: Object;
    url = new Url();
    userUrl = this.url.get_urlbase() + '/user';
    // userUrl = `http://localhost:8089/CBay_Project/rest/user/get`;
    // userUrl = `http://54.213.131.230:8089/CBay/rest/user/get`;

    constructor (public http: HttpClient) { }

    set_all_values(userInfo: any) {
        this.userid = userInfo.id;
        this.username = userInfo.userName;
        this.usertype = userInfo.userType;
        this.firstname = userInfo.firstName;
        this.lastname = userInfo.lastName;
        this.email = userInfo.email;
        this.password = userInfo.PW;
        if (userInfo.description === undefined) {
            console.log('not exist');
            this.description = '';
        } else {
            console.log('exist');
            this.description = userInfo.description;
        }
        this.rating = userInfo.ratingavg;
    }

    get_userName() {
        return this.username;
    }

    get(id: any): Promise<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type':  'application/json'
            })
        };
        console.log('url get: ' + this.userUrl + '/get/' + id);
        return this.http.get(this.userUrl + '/get/' + id, httpOptions)
            .toPromise();
    }

    get_all_admins() {
        const req = this.http.get(this.userUrl + '/get/all/admin', {headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })});
        return req;
    }

    get_all_users() {
      const req = this.http.get('http://54.213.131.230:8089/CBay/rest/user/get/all', {headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })});
      return req;
    }

    update() {
        const req = this.http.post(this.userUrl + '/edit', {
            id: this.userid,
            firstname: this.firstname,
            lastname: this.lastname,
            username: this.username,
            pw: this.password,
            description: this.description,
            email: this.email
        }, {responseType: 'text'});

        return req;
    }
}

