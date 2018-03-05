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
    public userInfo;
    public dataToPage = {};
    public disableEdit = true;
    public name: string;

    constructor(public http: HttpClient) {}

    ngOnInit() {
        this.itemUrl = `http://54.213.131.230:8089/CBay/rest/item/get`;
        this.itemInfo = {
            /*itemid: '20000',
            userid: '10001',
            itemname: 'Tv',
            description: 'Samsung Tv',
            price: '200',
            ratingavg: '0'*/
        };

        this.userInfo = {
            userid: '10001',
            username: 'BBobbert',
            email: 'B@gmail.com',
            description: 'I am a very trustworthy seller.',
            rating: '4.7/5'
        };

        this.set_page_data();
    }

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
        return Object.keys(this.dataToPage);
    }

    toggleEdit() {
        this.disableEdit = !this.disableEdit;
    }

    save_changes() {
        // TODO send data back to db
        this.toggleEdit();
    }

    set_page_data() {
        // Object.keys(obj).length isn't supported by IE8
        if (Object.keys(this.itemInfo).length === 0 && Object.keys(this.userInfo).length > 0) {
            this.dataToPage = this.userInfo;
            //delete this.dataToPage.username;
            console.log('display userinfo');
        } else if (Object.keys(this.itemInfo).length > 0 && Object.keys(this.userInfo).length === 0) {
            this.dataToPage = this.itemInfo;
            console.log('display iteminfo');
        }
        console.log('set_page_data()');
    }
}
