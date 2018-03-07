import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Item } from '../../shared/models/item';

@Component({
    selector: 'app-singleitem',
    templateUrl: './singleitem.component.html',
    styleUrls: ['./singleitem.component.css']
})
export class SingleitemComponent implements OnInit {
    itemModel: Item;

    constructor(public http: HttpClient) { }

    ngOnInit() {
        this.itemModel = new Item(this.http);

        this.itemModel.get(20000).then(item_data => {
            this.itemModel.set_all_valuse(item_data);
            console.log(this.itemModel);
        }).catch(error => {
            console.log(error);
        });
    }

}
