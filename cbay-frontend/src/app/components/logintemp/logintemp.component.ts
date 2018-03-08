import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-logintemp',
    templateUrl: './logintemp.component.html',
    styleUrls: ['./logintemp.component.css']
})
export class LogintempComponent {

    model = new Client('', '');
    submitted = false;

    constructor(public router: Router) { }

    onSubmit() {
        this.submitted = true;
        sessionStorage.setItem('userid', '10002');
        this.router.navigateByUrl('/profile');
    }

    // TODO: Remove this when we're done
    get diagnostic() { return JSON.stringify(this.model); }

    reset() {
        this.model = new Client('', '');
    }
}

export class Client {

    constructor(
    public userName: string,
     public password: string,
    ) {  }

}
