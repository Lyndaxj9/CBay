import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Title } from '@angular/platform-browser';
import { Item } from '../../shared/models/item';
import { Order } from '../../shared/models/order';
import { Client } from '../../shared/models/client';

@Component({
    selector: 'app-singleitem',
    templateUrl: './singleitem.component.html',
    styleUrls: ['./singleitem.component.css']
})
export class SingleitemComponent implements OnInit {
    itemId: number;
    itemModel: Item;
    itemQuantity: number;
    orderModel: Order;
    isBuyer: boolean;
    hasBought: boolean;
    verifyStatus = 'Checked-Out';
    verifyUsername = '';
    private sub: any;

    constructor(public http: HttpClient, private route: ActivatedRoute, private titleService: Title) { }

    ngOnInit() {
        this.titleService.setTitle('Item Information');

        this.itemModel = new Item(this.http);
        this.orderModel = new Order(this.http);
        this.sub = this.route.params
            .subscribe(
            params => {
                this.itemId = +params['id']; // (+) converts string 'id' to number
            });

        this.itemModel.get(this.itemId).then(item_data => {
            this.itemModel.set_all_values(item_data);
            console.log('singleitem ngOnInit(): ' + this.itemModel);
        }).catch(error => {
            console.log(error);
        });

        this.isBuyer = sessionStorage.getItem('usertype') === 'buyer';
        this.itemQuantity = 1;

        this.hasBought = false;
        this.verifiedPurchaser();
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

    verifiedPurchaser() {
        const userid = parseInt(sessionStorage.getItem('userid'), 10);
        this.orderModel.buyerid = userid;
        this.orderModel.get_checked_out().subscribe(
            res => {
                if (res != []) {
                    for (let k of Object.keys(res)) {
                        console.log(res[k]);
                        if (res[k].itemId === this.itemId && res[k].status === this.verifyStatus) {
                            console.log('can review');
                            this.hasBought = true;
                            const aClient = new Client(this.http);
                            aClient.get(userid)
                                .then(user_data => {
                                this.verifyUsername = user_data['userName'];
                            });
                            break;
                        }
                    }
                }
            },
            err => {
                console.log(err);
            }
        );
    }
}
