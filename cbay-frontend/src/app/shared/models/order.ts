import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Url } from './url';

export class Order {
    transid: number;
    transarray = [];
    orderid: number;
    itemid: number;
    buyerid: number;
    sellerid: number;
    quantity: number;
    status: string;
    url = new Url();
    orderUrl = this.url.get_urlbase() + '/order';

    constructor (public http: HttpClient) { }

    insert() {
        const req = this.http.post(this.orderUrl + '/post/tocart', {
            itemid: this.itemid,
            buyerid: this.buyerid,
            sellerid: this.sellerid,
            quantity: this.quantity
        }, {responseType: 'text'});

        return req;
    }

    get_cart() {
        return this.http.get(this.orderUrl + '/get/cart/' + this.buyerid + '/' + 'In-Cart', {headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })});
    }

    get_checked_out() {
        return this.http.get(this.orderUrl + '/get/cart/' + this.buyerid + '/' + 'Checked-Out', {headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })});
    }

    get_all_order() {
        return this.http.get(this.orderUrl + '/get/cart/' + this.buyerid + '/' + 'In-Cart', {headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })});
    }

    checkout_status() {
        console.log(this.transarray);
        const req = this.http.post(this.orderUrl + '/post', {
            transactionlist: this.transarray,
            id: this.buyerid
        }, {responseType: 'text'});

        return req;
    }

    update_trans_shipped() {
        const req = this.http.post(this.orderUrl + '/update/shipped/' + this.transid, { }, {responseType: 'text'});

        return req;
    }

    update_trans_delivered() {
        const req = this.http.post(this.orderUrl + '/update/delivered/' + this.transid, { }, {responseType: 'text'});

        return req;
    }

    update_trans_canceled() {
        const req = this.http.post(this.orderUrl + '/update/canceled/' + this.transid, { }, {responseType: 'text'});

        return req;
    }

    update_rm_from_cart() {
        const req = this.http.post(this.orderUrl + '/update/removefromcart/' + this.transid, { }, {responseType: 'text'});

        return req;
    }
}
