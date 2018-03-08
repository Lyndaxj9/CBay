import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

export class Order {
    transid: number;
    orderid: number;
    itemid: number;
    buyerid: number;
    sellerid: number;
    quantity: number;
    status: string;

    orderUrl = `http://localhost:8089/CBay_Project/rest/order`;

    constructor (public http: HttpClient) { }

    update() {
        const req = this.http.post(this.orderUrl + '/post/tocart', {
            itemid: this.itemid,
            buyerid: this.buyerid,
            sellerid: this.sellerid,
            quantity: this.quantity
        }, {responseType: 'text'});

        return req;
    }
}
