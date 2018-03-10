import { Component, OnInit, AfterContentInit, Input } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Client } from '../../shared/models/client';
import { Item } from '../../shared/models/item';
import { Image } from '../../shared/models/image';

@Component({
    selector: 'app-entity-display',
    templateUrl: './entitydisplay.component.html'
})

export class EntityDisplayComponent implements OnInit, AfterContentInit {
    @Input() aUser: Client;
    @Input() anItem: Item;

    public itemId: number;
    public userId: string;
    public currentUserId;
    public itemUrl: string;
    public userModel;
    public itemModel;
    public imageModel;
    public name: string;
    itemImage: any;
    public disableEdit = true;
    public data = {
        id: 0,
        name: '',
        editAble: {},
        nonEditable: {}
    };

    constructor(public http: HttpClient) { }

    ngOnInit() {
        this.currentUserId = sessionStorage.getItem('userid');
        console.log('current user: ' + this.currentUserId);
    }

    ngAfterContentInit() {
        if (this.aUser != null) {
            console.log('init user');
            this.get_user();
        } else if (this.anItem != null) {
            console.log('init item');
            this.get_item();
        }
    }

    get_item() {
        this.itemId = 20000;
        console.log(this.itemId);
        console.log('from input: ' + this.anItem.itemname);

        this.data.id = this.anItem.itemid;
        this.data.name = this.anItem.itemname;
        this.data.editAble['Description'] = this.anItem.description;
        this.userId = '' + this.anItem.userid;
        const user = new Client(this.http);

        /* this.imageModel = new Image(this.http);
        this.imageModel.get_images().subscribe(
            res => {
                console.log(res);
            },
            err => {
                console.log(err);
            }
        );*/

        user.get(this.userId).then(user_data => {
            // this.data.nonEditable['Seller'] = user_data['userName'];
            this.data['Seller'] = user_data['userName'];
            this.data.nonEditable['Price'] = '$' + this.anItem.price;
            this.data.nonEditable['Product Rating'] = this.anItem.ratingavg;
            // TODO sold out if quantity == 0 and don't display add to cart
            this.data.nonEditable['Quantity'] = this.anItem.quantity;
        }).catch(error => {
            console.log(error);
            // TODO probably change to an item doesn't exist message or page
        });
    }

    get_user() {
        this.userId = '' + this.aUser.userid;
        this.currentUserId = sessionStorage.getItem('userid');
        console.log('current user: ' + this.currentUserId + 'compare user: ' + this.userId);

        console.log('from input: ' + this.aUser.username);
        this.data.id = this.aUser.userid;
        this.data.name = this.aUser.username;
        this.data.editAble['First Name'] = this.aUser.firstname;
        this.data.editAble['Last Name'] = this.aUser.lastname;
        this.data.editAble['E-Mail'] = this.aUser.email;
        this.data.nonEditable['User Type'] = this.aUser.usertype;
        if (this.aUser.usertype === 'Seller') {
            this.data.editAble['Description'] = this.aUser.description;
        }
    }

    keys(obj): Array<string> {
        return Object.keys(obj);
    }

    toggleEdit() {
        this.disableEdit = !this.disableEdit;
    }

    save_changes() {
        if (this.anItem != null) {
            this.anItem.itemname = this.data.name;
            this.anItem.price = this.data.nonEditable['Price'];
            this.anItem.description = this.data.editAble['Description'];
            const o = this.anItem.update();
            o.subscribe(
                res => {
                    console.log(res + ' it was good');
                },
                err => {
                    console.log(err);
                }
            );
        } else if (this.aUser != null) {
            this.aUser.firstname = this.data.editAble['First Name'];
            this.aUser.lastname = this.data.editAble['Last Name'];
            this.aUser.email = this.data.editAble['E-Mail'];
            if (this.aUser.usertype === 'Seller') {
                this.aUser.description = this.data.editAble['Description'];   
            }
            console.log('entitydisplay desc: ' + this.aUser.description);
            const o = this.aUser.update();
            o.subscribe(
                res => {
                    console.log(res + ' user update good');
                },
                err => {
                    console.log(err);
                }
            );
        }
        this.toggleEdit();
    }

    nonEditableData() {
        return this.data.nonEditable === {};
    }
}
