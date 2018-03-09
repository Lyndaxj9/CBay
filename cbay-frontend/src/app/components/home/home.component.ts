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
        console.log('home');
        this.userid = parseInt(sessionStorage.getItem('userid'), 10);
        this.usertype = sessionStorage.getItem('usertype');
        console.log(this.userid + ' ' + this.usertype);

<<<<<<< HEAD
        /*if (parseInt(sessionStorage.getItem('userid'), 10)) {
            this.router.navigateByUrl('\profile');
        }*/

=======
>>>>>>> a38d7a52d35e0e11bff76375cb64a64c4c7d6c0d
        if (!parseInt(sessionStorage.getItem('userid'), 10)) {
        } else {
            console.log('redirect to profile');
            this.router.navigate(['/profile', this.userid]);
        }
    }

}
