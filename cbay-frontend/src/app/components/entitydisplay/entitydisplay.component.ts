import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
    selector: 'app-entity-display',
    templateUrl: './entitydisplay.component.html'
})

export class EntityDisplayComponent implements OnInit {
    public itemId: string;
    public itemUrl: string;
    constructor(public http: HttpClient) {}
    
    ngOnInit() {
        this.itemId;
        this.itemUrl = `http://localhost:8089/CBay_Project/rest/item/get`;
    }

    public itemInfo = {
        itemid: '',
        userid: '',
        itemname: '',
        description: '',
        price: '',
        ratingavg: ''
    };

    data = 'name';
    dbresult = [
        2, 'Bobbert', 'seller', 'b@gmail.com', 'I am a very trustworthy seller', '4.5/5'
    ];
    canEdit: boolean = true;

    get_item() {
        this.itemId = '20000';
        console.log(this.itemId);
        console.log(this.itemUrl + '/' + this.itemId);
        this.get_item_data().then(item_data => {
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
}
