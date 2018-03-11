import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Title } from '@angular/platform-browser';
import { Item } from '../../shared/models/item';
import { Order } from '../../shared/models/order';
import { Router } from '@angular/router';

@Component({
    selector: 'app-cart',
    templateUrl: './cart.component.html',
    styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
    orderModel: Order;
    itemModel: Item;
    total = 0;
    checkedOut: boolean;

    transactions: any;
    currentCart: Array<Item>;

    constructor(public http: HttpClient, private router: Router, private titleService: Title) { }

    ngOnInit() {
        this.titleService.setTitle('Cart');

        this.orderModel = new Order(this.http);
        this.orderModel.buyerid = parseInt(sessionStorage.getItem('userid'), 10);
        this.itemModel = new Item(this.http);
        this.currentCart = new Array();
        this.checkedOut = false;

        this.orderModel.get_cart().subscribe(
            res => {
                this.transactions = res;
                this.getItemInfo();
            },
            err => {
                console.log(err);
            }
        );
    }

    getItemInfo() {
        console.log(this.transactions);
        for (let i of this.transactions) {
            this.itemModel.get(i.itemId).then(item_data => {
                let anItem = new Item(this.http);
                console.log(item_data);
                anItem.itemid = item_data['id'];
                anItem.itemname = item_data['itemName'];
                anItem.price = item_data['price'];
                anItem.description = item_data['description'];
                anItem.quantity = i.quantity;
                anItem['subtotal'] = i.quantity * anItem.price;
                anItem['transid'] = i.id;
                this.total += anItem['subtotal'];
                this.currentCart.push(anItem);
            }).catch(error => {
                console.log(error);
            });
        }
    }

    checkout() {
        console.log('checkout');
        for (let t of this.transactions) {
            this.orderModel.transarray.push(t.id);
        }
        this.orderModel.checkout_status().subscribe(
            res => {
                console.log(res);
                this.checkedOut = true;
                setTimeout((router: Router) => {
                    this.router.navigate(['list/orders']);
                }, 2575);
            },
            err => {
                console.log(err);
            }
        );
    }

    remove_from_cart(tid) {
        console.log('rm from cart: ' + tid);
        this.orderModel.transid = tid;
        this.orderModel.update_rm_from_cart().subscribe(
            res => {
                console.log(res);
                window.location.reload();
            },
            err => {
                console.log(err);
            }
        );
    }
}
