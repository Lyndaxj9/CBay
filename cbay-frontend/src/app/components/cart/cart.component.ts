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
    total = 0;

    transactions: any;
    currentCart: Array<Item>;

    constructor(public http: HttpClient) { }

    ngOnInit() {
        this.orderModel = new Order(this.http);
        this.orderModel.buyerid = parseInt(sessionStorage.getItem('userid'), 10);
        this.itemModel = new Item(this.http);
        this.currentCart = new Array();

        this.orderModel.get_cart().subscribe(
            res => {
                this.transactions = res;
                console.log(res);
                this.getItemInfo();
            },
            err => {
                console.log(err);
            }
        );
    }

    getItemInfo() {
        for (let i of this.transactions) {
            this.itemModel.get(i.itemId).then(item_data => {
                let anItem = new Item(this.http);
                anItem.itemid = i.itemid;
                anItem.itemname = item_data['itemName'];
                anItem.price = item_data['price'];
                anItem.description = item_data['description'];
                anItem.quantity = i.quantity;
                anItem['subtotal'] = i.quantity * anItem.price;
                this.total += anItem['subtotal'];
                this.currentCart.push(anItem);
            }).catch(error => {
                console.log(error);
            });
        }
    }

}
