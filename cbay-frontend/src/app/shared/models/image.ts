import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

export class Image {
    imageid: number;
    itemid: number;
    image = [];
    filename: string;

    imageUrl = `http://localhost:8089/CBay_Project/rest/image`;

    constructor (public http: HttpClient) { }

    get_images() {
        const req = this.http.get(this.imageUrl + '/get/itemimage/' + this.itemid, {headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })});
        return req;
    }
}
