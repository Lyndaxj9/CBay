import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';

export class Item {
    itemid: number;
    userid: number;
    itemname: string;
    description: string;
    price: number;
    ratingavg: number;
    quantity: number;
    itemUrl = `http://localhost:8089/CBay_Project/rest/item/get`;
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
        return this.http.get(this.itemUrl + '/' + id, httpOptions)
            .toPromise();
    }

    update() {
        const req = this.http.post('http://localhost:8089/CBay_Project/rest/item/update', {
            id: this.itemid,
            itemName: this.itemname,
            description: this.description,
            price: this.price
        }, {responseType: 'text'});

        return req;
    }
}
