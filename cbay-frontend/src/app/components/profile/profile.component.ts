import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Client } from '../../shared/models/client';

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
    clientModel: Client;

    constructor(public http: HttpClient) { }

    ngOnInit() {
        this.clientModel = new Client(this.http);

        // TODO probably have to change to get username so other way
        this.clientModel.get('10001')
            .then(user_data => {

            this.clientModel.set_all_values(user_data);
            console.log(this.clientModel);
        }).catch(error => {
            console.log(error);
        });
    }

}
