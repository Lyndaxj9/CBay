import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

export class Rating {
    ratingid: number;
    itemid: number;
    userid: number;
    numrating: number;
    textrating: string;

    imageUrl = `http://localhost:8089/CBay_Project/rest/rating`;

    constructor (public http: HttpClient) { }

    get_seller_rating() {
        const req = this.http.get(this.imageUrl + '/get/itemimage/' + this.itemid, {headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })});
        return req;
    }
}
