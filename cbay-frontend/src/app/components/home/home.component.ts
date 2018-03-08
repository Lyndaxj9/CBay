import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

    constructor() {
        sessionStorage.setItem('userid', '10002');
        sessionStorage.setItem('usertype', 'Seller');
    }

    ngOnInit() {
    }

}
