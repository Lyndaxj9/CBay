import { Component, OnInit } from '@angular/core';
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
    public userid: number;

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

    login() {
        this.type = 'seller';
        console.log('username : ' + this.username);
        console.log('password : ' + this.password);
        console.log('type : ' + this.type);
        console.log(this.url + '/' + this.username + '/' + this.password + '/' + this.type);
        this.get_user_data().then(user_data => {
            localStorage.setItem('userid', user_data);
            console.log(user_data);
        }).catch(error => {
            console.log(error);
        });
    }

    register() {
        console.log(this.password);
        console.log(this.username);
        console.log(this.email);
        console.log(this.confirm_password);
    }

    logout() {
        sessionStorage.clear();
        this.userid = null;
        console.log('logged out');
        this.router.navigateByUrl('');
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
}
