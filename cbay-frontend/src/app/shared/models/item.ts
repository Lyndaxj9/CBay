import { HttpClient, HttpHeaders } from '@angular/common/http';

export class Item {
    itemid: number;
    userid: number;
    itemname: string;
    description: string;
    price: number;
    ratingavg: number;
    itemUrl = `http://localhost:8089/CBay_Project/rest/item/get`;

    constructor (public http: HttpClient) { }

    get(id: number): Promise<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type':  'application/json'
            })
        };
        return this.http.get(this.itemUrl + '/' + id, httpOptions)
            .toPromise();
    }
}
