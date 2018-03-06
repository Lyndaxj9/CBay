import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Client } from '../../shared/models/client';

@Component({
    selector: 'app-entity-display',
    templateUrl: './entitydisplay.component.html'
})

export class EntityDisplayComponent implements OnInit {
    public itemId: string;
    public userId: string;
    public currentUserId = '0';
    public itemUrl: string;
    public userUrl: string;
    public itemInfo;
    public userInfo;
    public userModel;
    public name: string;
    public dataToPage = {};
    public nonEditable = {};
    public disableEdit = true;

    constructor(public http: HttpClient) {}

    ngOnInit() {
        console.log(this.currentUserId);
        this.itemUrl = `http://localhost:8089/CBay_Project/rest/item/get`;
        this.itemInfo = {
           /* itemid: '20000',
            userid: '10001',
            itemname: 'Tv',
            description: 'Samsung Tv',
            price: '200',
            ratingavg: '0'*/
        };

        this.userUrl = `http://localhost:8089/CBay_Project/rest/user/get`;
        this.userInfo = {
            /*userid: '10001',
            username: 'BBobbert',
            email: 'B@gmail.com',
            description: 'I am a very trustworthy seller.',
            rating: '4.7/5'*/
        };
    }

    get_item() {
        this.itemId = '20000';
        console.log(this.itemId);
        console.log(this.itemUrl + '/' + this.itemId);
        this.get_item_data().then(item_data => {
            this.dataToPage = {};
            this.nonEditable = {};

            this.name = item_data['itemName'];
            this.userId = item_data['userId'];
            this.nonEditable['Price'] = item_data['price'];
            this.nonEditable['Product Rating'] = item_data['ratingAvg'];
            this.dataToPage['Description'] = item_data['description'];

            console.log(item_data);
        }).catch(error => {
            console.log(error);
        });
    }

    get_item_data(): Promise<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type':  'application/json'
            })
        };
        return this.http.get(this.itemUrl + '/' + this.itemId, httpOptions)
            .toPromise();
    }

    get_user() {
        this.userId = localStorage.getItem('userid');
        this.currentUserId = '10001';
        console.log('current user: ' + this.currentUserId + 'compare user: ' + this.userId);
        this.userModel = new Client(this.http);
        // console.log(this.userUrl + '/' + this.userId);
        this.userModel.get(this.userId).then(user_data => {
        // this.get_user_data().then(user_data => {
            this.dataToPage = {};
            this.nonEditable = {};

            delete user_data['PW'];

            this.name = user_data['userName'];
            this.userId = user_data['id'];
            this.nonEditable['User Type'] = user_data['userType'];
            this.dataToPage['First Name'] = user_data['firstName'];
            this.dataToPage['Last Name'] = user_data['lastName'];
            this.dataToPage['e-mail'] = user_data['email'];

            delete user_data['userName'];
            delete user_data['id'];
            delete user_data['userType'];

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
        return this.http.get(this.userUrl + '/' + this.userId, httpOptions)
            .toPromise();
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
        return this.nonEditable === {};
    }
}
