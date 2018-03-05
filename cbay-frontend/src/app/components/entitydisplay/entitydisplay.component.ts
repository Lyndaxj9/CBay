import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
    selector: 'app-entity-display',
    templateUrl: './entitydisplay.component.html'
})

export class EntityDisplayComponent implements OnInit {
    public itemId: string;
    public itemUrl: string;
    public itemInfo;
    public disableEdit = true;
    
    constructor(public http: HttpClient) {}
    
    ngOnInit() {
        this.itemId;
        this.itemUrl = `http://54.213.131.230:8089/CBay/rest/item/get`;
        this.itemInfo = {
        itemid: '20000',
        userid: '10001',
        itemname: 'Tv',
        description: 'Samsung Tv',
        price: '200',
        ratingavg: '0'
        };
    }

    data = 'name';

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

    keys(): Array<string> {
        return Object.keys(this.itemInfo);
    }

    toggleEdit() {
        this.disableEdit = !this.disableEdit;
    }

    save_changes() {
        // TODO send data back to db
        this.toggleEdit();
    }
}
