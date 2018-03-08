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

    constructor(private router: Router) {
        sessionStorage.setItem('userid', '10002');
        sessionStorage.setItem('usertype', 'Seller');
    }

    ngOnInit() {
        this.userid = parseInt(sessionStorage.getItem('userid'), 10);
        this.usertype = sessionStorage.getItem('usertype');

        if (parseInt(sessionStorage.getItem('userid'), 10)) {
            this.router.navigateByUrl('\profile');
        }
    }

}
