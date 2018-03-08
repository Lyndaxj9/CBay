import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    userid: number;
    usertype: string;

    constructor(private router: Router) { }

    ngOnInit() {
        console.log("home");
        this.userid = parseInt(sessionStorage.getItem('userid'), 10);
        this.usertype = sessionStorage.getItem('usertype');
        console.log(this.userid + ' ' + this.usertype);

        if (!parseInt(sessionStorage.getItem('userid'), 10)) {
        } else {
            console.log("redirect to profile");
            this.router.navigateByUrl('/profile');
        }
    }

}
