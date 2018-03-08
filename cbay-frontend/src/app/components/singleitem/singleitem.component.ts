import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Item } from '../../shared/models/item';
import { Order } from '../../shared/models/order';

@Component({
    selector: 'app-singleitem',
    templateUrl: './singleitem.component.html',
    styleUrls: ['./singleitem.component.css']
})
export class SingleitemComponent implements OnInit {
    itemModel: Item;
    itemQuantity: number;
    orderModel: Order;

    constructor(public http: HttpClient) { }

    ngOnInit() {
        this.itemModel = new Item(this.http);
        this.orderModel = new Order(this.http);

        this.itemModel.get(20000).then(item_data => {
            this.itemModel.set_all_values(item_data);
            console.log('singleitem ngOnInit(): ' + this.itemModel);
        }).catch(error => {
            console.log(error);
        });

        this.itemQuantity = 1;
    }

    add_to_cart() {
        if (this.itemQuantity <= this.itemModel.quantity) {
            console.log('add_to_cart ' + this.itemQuantity + ' item(s)');
            this.orderModel.itemid = this.itemModel.itemid;
            this.orderModel.buyerid = parseInt(sessionStorage.getItem('userid'), 10);
            this.orderModel.sellerid = this.itemModel.userid;
            this.orderModel.quantity = this.itemQuantity;

            this.orderModel.insert().subscribe(
                res => {
                    console.log(res);
                },
                err => {
                    console.log(err);
                });
        } else {
            console.log('insuffient amount');
        }
    }

}
