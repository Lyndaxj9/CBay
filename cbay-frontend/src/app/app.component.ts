import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
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
    userid: number;

    constructor(public http: HttpClient, public router: Router) { }

    ngOnInit() {
        this.password = '';
        this.confirm_password = '';
        this.username = '';
        this.email = '';
        this.userid = parseInt(sessionStorage.getItem('userid'), 10);
        console.log('current userid: ' + this.userid);
    }

    logout() {
        sessionStorage.clear();
        this.userid = null;
        console.log('logged out');
        this.router.navigateByUrl('/');
    }

    my_profile() {
        this.router.onSameUrlNavigation = 'reload';
        this.router.navigate(['/profile', sessionStorage.getItem('userid')]);
    }

    search_items(){
      sessionStorage.setItem('list_type', 'item');
      this.router.navigate(['/list/item']).catch(error => {
        console.log(error);
      });
    }

    go_to_my_cart(){
      sessionStorage.setItem('list_type', 'cart');
      this.router.navigate(['/cart']).catch(error => {
        console.log(error);
      });
    }
}
