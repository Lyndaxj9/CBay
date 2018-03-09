import { Component, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
    public password: string;
    public username: string;
    public confirm_password: string;
    public type: string;
    public email: string;
    public url: string;
    userid: number;

    constructor(public http: HttpClient, public router: Router) { }

    ngOnInit() {
        this.password = '';
        this.confirm_password = '';
        this.username = '';
        this.email = '';
        this.userid = parseInt(sessionStorage.getItem('userid'), 10);
        // this.url = `http://54.213.131.230:8089/CBay/rest/user/get`;
        this.url = `http://localhost:8089/CBay_Project/rest/user/get`;
        console.log("current userid: " + this.userid);
    }

    ngOnChanges(changes: SimpleChanges) {
        console.log("on changes");
        console.log(changes);
        this.userid = parseInt(sessionStorage.getItem('userid'), 10);
    }

    logout() {
        sessionStorage.clear();
        this.userid = null;
        console.log('logged out');
        this.router.navigateByUrl('/');
    }

    get_user_data(): Promise<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type':  'application/json'
            })
        };
        return this.http.get(this.url + '/' + this.username + '/' + this.password + '/' + this.type, httpOptions)
            .toPromise();
    }

    my_profile() {
        this.router.onSameUrlNavigation = 'reload';
        this.router.navigate(['/profile', sessionStorage.getItem('userid')]);
    }

    search_items(){
      sessionStorage.setItem('list_type', 'item');
      this.router.navigate(['/list']).catch(error => {
        console.log(error);
      });
    }

    go_to_my_cart(){
      sessionStorage.setItem('list_type', 'cart');
      this.router.navigate(['/list']).catch(error => {
        console.log(error);
      });
    }
}
