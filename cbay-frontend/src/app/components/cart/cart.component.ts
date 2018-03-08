import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Item } from '../../shared/models/item';
import { Order } from '../../shared/models/order';

@Component({
    selector: 'app-cart',
    templateUrl: './cart.component.html',
    styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
    orderModel: Order;
    itemModel: Item;

    transactions = [];
    currentCart: Array<Item>;

    constructor(public http: HttpClient) { }

    ngOnInit() {
        this.orderModel = new Order(this.http);
        this.itemModel = new Item(this.http);
        this.currentCart = new Array();

        this.transactions = [
            {
                'transactionid': 30022,
                'itemid': 20000,
                'buyerid': 10001,
                'sellerid': 10000,
                'status': 'In-Cart',
                'quantity': 1
            },
            {
                'transactionid': 30020,
                'itemid': 20001,
                'buyerid': 10000,
                'sellerid': 10001,
                'status': 'In-Cart',
                'quantity': 4
            },
            {
                'transactionid': 30021,
                'itemid': 20001,
                'buyerid': 10001,
                'sellerid': 10000,
                'status': 'In-Cart',
                'quantity': 1
            }
        ];
        this.getItemInfo();
    }

    getItemInfo() {
        for (let i of this.transactions) {
            this.itemModel.get(i.itemid).then(item_data => {
                let anItem = new Item(this.http);
                anItem.itemid = i.itemid;
                anItem.itemname = item_data['itemName'];
                anItem.price = item_data['price'];
                anItem.description = item_data['description'];
                anItem.quantity = i.quantity;
                this.currentCart.push(anItem);
            }).catch(error => {
                console.log(error);
            });
        }
    }

}
