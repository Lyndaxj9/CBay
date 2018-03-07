import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
    selector: 'app-logintemp',
    templateUrl: './logintemp.component.html',
    styleUrls: ['./logintemp.component.css']
})
export class LogintempComponent implements OnInit {
    public password: string;
    public username: string;
    public confirm_password: string;
    public type: string;
    public email: string;
    public url: string;

    constructor(public http: HttpClient) { }

    ngOnInit() {
        this.password = '';
        this.confirm_password = '';
        this.username = '';
        this.email = '';
        // this.url = `http://54.213.131.230:8089/CBay/rest/user/get`;
        this.url = `http://localhost:8089/CBay_Project/rest/user/get`;
    }

    login() {
        this.type = 'seller';
        console.log('username : ' + this.username);
        console.log('password : ' + this.password);
        console.log('type : ' + this.type);
        console.log(this.url + '/' + this.username + '/' + this.password + '/' + this.type);
        this.get_user_data().then(user_data => {
            if (user_data != null) {
                sessionStorage.setItem('userid', user_data);
                console.log('session stored for : ' + user_data);
            }
            console.log(user_data);
        }).catch(error => {
            console.log(error);
        });
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