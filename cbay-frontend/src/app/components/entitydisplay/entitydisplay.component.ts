import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Client } from '../../shared/models/client';
import { Item } from '../../shared/models/item';

@Component({
    selector: 'app-entity-display',
    templateUrl: './entitydisplay.component.html'
})

export class EntityDisplayComponent implements OnInit {
    public itemId: string;
    public userId: string;
    public currentUserId;
    public itemUrl: string;
    public userModel;
    public itemModel;
    public name: string;
    public dataToPage = {};
    public nonEditable = {};
    public disableEdit = true;
    public data = {
                id: 0,
                name: '',
                editAble: {},
                nonEditable: {}
            };

    constructor(public http: HttpClient) {}

    ngOnInit() {
        this.currentUserId = sessionStorage.getItem('userid');
        console.log('current user: ' + this.currentUserId);
    }

    get_item() {
        this.itemId = '418';
        console.log(this.itemId);
        this.itemModel = new Item(this.http);

        this.itemModel.get(this.itemId).then(item_data => {
            this.data.id = item_data['id'];
            this.data.name = item_data['itemName'];

            this.data.editAble['Description'] = item_data['description'];

            this.userModel = new Client(this.http);
            this.userModel.get(item_data['userId']).then(user_data => {
                this.data.nonEditable['Seller'] = user_data['userName'];
                this.data.nonEditable['Price'] = item_data['price'];
                this.data.nonEditable['Product Rating'] = item_data['ratingAvg'];
            });

            console.log(item_data);
        }).catch(error => {
            console.log(error);
        });
    }

    get_user() {
        this.userId = sessionStorage.getItem('userid');
        this.currentUserId = '10001';
        console.log('current user: ' + this.currentUserId + 'compare user: ' + this.userId);
        this.userModel = new Client(this.http);

        this.userModel.get(this.userId).then(user_data => {
            console.log(user_data);

            let userID;
            let name;
            let editAble = {};
            let nonEditable = {};
            // this.password = user_data['PW'];
            // delete user_data['PW'];

            userID = user_data['id'];
            name = user_data['userName'];
            editAble['First Name'] = user_data['firstName'];
            editAble['Last Name'] = user_data['lastName'];
            editAble['e-mail'] = user_data['email'];
            nonEditable['User Type'] = user_data['userType'];

            // TODO how to get this as an accessable object
            this.data = {
                id: userID,
                name: name,
                editAble: editAble,
                nonEditable: nonEditable
            };
            console.log('user: ' + this.data['editAble']);
        }).catch(error => {
            console.log(error);
        });
    }

    keys(obj): Array<string> {
        return Object.keys(obj);
    }

    toggleEdit() {
        this.disableEdit = !this.disableEdit;
    }

    save_changes() {
        // TODO send data back to db
        this.toggleEdit();
    }

    nonEditableData() {
        return this.data.nonEditable === {};
    }
}
