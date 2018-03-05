import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
    selector: 'app-entity-display',
    templateUrl: './entitydisplay.component.html'
})

export class EntityDisplayComponent implements OnInit {
    public itemId: string;
    public userId: string;
    public currentUserId = 0;
    public userIdNum: number;
    public itemUrl: string;
    public userUrl: string;
    public itemInfo;
    public userInfo;
    public name: string;
    public dataToPage = {};
    public nonEditable = {};
    public disableEdit = true;

    constructor(public http: HttpClient) {}

    ngOnInit() {
        console.log(this.currentUserId);
        this.itemUrl = `http://54.213.131.230:8089/CBay/rest/item/get`;
        this.itemInfo = {
            itemid: '20000',
            userid: '10001',
            itemname: 'Tv',
            description: 'Samsung Tv',
            price: '200',
            ratingavg: '0'
        };

        this.userUrl = `http://localhost:8089/CBay_Project/rest/user/get`;
        this.userInfo = {
            /*userid: '10001',
            username: 'BBobbert',
            email: 'B@gmail.com',
            description: 'I am a very trustworthy seller.',
            rating: '4.7/5'*/
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

    get_user() {
        this.userId = localStorage.getItem('userid');
        this.userIdNum = parseInt(localStorage.getItem('userid'));
        this.currentUserId = 10020;
        // console.log(this.userId);
        // console.log(this.userUrl + '/' + this.userId);
        this.get_user_data().then(user_data => {
            delete user_data['PW'];

            this.name = user_data['userName'];
            this.userId = user_data['id'];
            this.nonEditable['User_Type'] = user_data['userType'];

            delete user_data['userName'];
            delete user_data['id'];
            delete user_data['userType'];

            this.dataToPage = user_data;
            console.log(user_data);
        }).catch(error => {
            console.log(error);
        });
    }

    get_user_data(): Promise<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type':  'application/json'
            })
        };
        return this.http.get(this.userUrl + '/' + this.userId, httpOptions)
            .toPromise();
    }

    keys(obj): Array<string> {
        return Object.keys(obj);
    }

    toggleEdit() {
        this.disableEdit = !this.disableEdit;
    }

    save_changes() {
        // TODO send data back to db
        this.toggleEdit();
    }

    nonEditableData() {
        return this.nonEditable === {};
    }

    set_page_data() {
        // Object.keys(obj).length isn't supported by IE8
        if (Object.keys(this.itemInfo).length === 0 && Object.keys(this.userInfo).length > 0) {
            this.dataToPage = this.userInfo;

            this.name = this.userInfo.username;
            delete this.dataToPage['username'];

            this.userId = this.userInfo.userid;
            delete this.dataToPage['userid'];

            console.log('display userinfo');
        } else if (Object.keys(this.itemInfo).length > 0 && Object.keys(this.userInfo).length === 0) {
            this.dataToPage = this.itemInfo;

            this.name = this.itemInfo.itemname;
            delete this.dataToPage['itemname'];

            this.userId = this.itemInfo.userid;
            delete this.dataToPage['userid'];

            this.itemId = this.itemInfo.itemid;
            delete this.dataToPage['itemid'];

            console.log('display iteminfo');
        }
        console.log('set_page_data()');
    }
}
