import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';
import { Url } from './url';

export class Item {
    itemid: number;
    userid: number;
    itemname: string;
    description: string;
    price: number;
    ratingavg: number;
    quantity: number;
    url = new Url();
    itemUrl = this.url.get_urlbase() + '/item';
    // itemUrl = `http://54.213.131.230:8089/CBay/rest/item/get`;

    constructor (public http: HttpClient) { }

    set_all_values(itemInfo: any) {
        this.itemid = parseInt(itemInfo.id, 10);
        this.userid = parseInt(itemInfo.userId, 10);
        this.itemname = itemInfo.itemName;
        this.description = itemInfo.description;
        this.price = itemInfo.price;
        this.ratingavg = itemInfo.ratingAvg;
        this.quantity = itemInfo.quantity;
    }

    // TODO a get username by userid would be nice

    get(id: number): Promise<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type':  'application/json'
            })
        };
        return this.http.get(this.itemUrl + '/get/' + id, httpOptions)
            .toPromise();
    }

    update() {
        const req = this.http.post(this.itemUrl + '/update', {
            id: this.itemid,
            itemName: this.itemname,
            description: this.description,
            price: this.price
        }, {responseType: 'text'});

        return req;
    }

    public get_all_items() {
        return this.http.get(this.itemUrl + '/get/all', {headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })});
    }

    post() {
        const req = this.http.post(this.itemUrl + '/post', {
            sellerId: this.userid,
            itemName: this.itemname,
            description: this.description,
            price: this.price,
            quantity: this.quantity
        }, {responseType: 'text'});

        return req;
    }

    update_quantity() {
        const req = this.http.post(this.itemUrl + '/post', {
            itemid: this.itemid,
        }, {responseType: 'text'});

        return req;
    }
}
