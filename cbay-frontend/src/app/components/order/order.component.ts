import { Component, OnInit } from '@angular/core';
import { Order } from '../../shared/models/order';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import {Item} from '../../shared/models/item';
import { Client } from '../../shared/models/client';
import { Message } from '../../shared/models/message';
import {Url} from '../../shared/models/url';
import { Title } from '@angular/platform-browser';


@Component({
    selector: 'app-order',
    templateUrl: './order.component.html',
    styleUrls: ['./order.component.css']
})

export class OrderComponent implements OnInit {

    private list = [];
    is_item_display: boolean;
    private temp_list: Post[];
    max_number_of_items_on_a_page = 6;
    current_page = 1;
    last_page = 1;
    current_index = 0;
    item: Item;
    orderModel: Order;
    transactions: any;
    url = new Url();

    report_types = ['Order Not Timely Shipped', 'Order Never Delivered', 'Order Cancelled'];
    mods: any;

    constructor(private http: HttpClient, private router: Router, private titleService: Title) {
    }


    view_item(id) {
        this.router.navigate(['item/', id]).catch(error => {
            console.log(error);
        });
    }

    ngOnInit() {
        this.titleService.setTitle('Orders');
        this.item = new Item(this.http);
        this.orderModel = new Order(this.http);
        this.list = [];
        this.temp_list = [];
        const user_id = Number.parseInt(sessionStorage.getItem('userid'));
        this.is_item_display = true;
        console.log(this.url.get_urlbase() + '/order/get/all');
        this.http.get<Post[]>(this.url.get_urlbase() + '/order/get/all').subscribe(res => {
            console.log(res);
            let size = res.length;
            let i = 0;
            console.log(user_id);

            res.forEach(ritem => {
                if (user_id === ritem['buyerId']) {
                    this.orderModel.orderid = ritem['id'];
                    this.orderModel.get_all_order_trans().subscribe(
                        trans => {
                            this.transactions = trans;
                            for(let i of this.transactions) {
                            console.log('trans:');
                                console.log(i);
                            this.item.get(i['itemId']).then(
                                item_data => {
                                    let anItem = new Item(this.http);
                                    anItem['transid'] = i['id']
                                    anItem['status'] = i['status'];
                                    anItem['itemid'] = item_data['id'];
                                    anItem['itemname'] = item_data['itemName'];
                                    anItem['price'] = item_data['price'];
                                    anItem['description'] = item_data['description'];
                                    anItem['quantity'] = i['quantity'];
                                    console.log('quantity: ' + i['quantity'] + ' price: ' + item_data['price'])
                                    anItem['subtotal'] = i['quantity'] * item_data['price'];
                                    console.log('after assignments');
                                    anItem['msgDisplayed'] = false;
                                    console.log(anItem);
                                    anItem['msgSubject'] = '';
                                    anItem['mod'] = '';
                                    anItem['msg'] = '';
                                    this.list.push(anItem);
                                }).catch(error => {
                                console.log(error);
                            });
                            }
                        }, err => {
                            console.log(err);
                        });
                }

                i = i + 1;
                if (size <= i && this.list) {
                    this.temp_list = this.list.slice(0, this.max_number_of_items_on_a_page);
                    this.last_page = Math.ceil(this.list.length / this.max_number_of_items_on_a_page);
                }
            });
        });

        this.get_mods();
    }

    next() {
        if (this.last_page > this.current_page) {
            this.current_index += this.max_number_of_items_on_a_page;
            this.temp_list = this.list.slice(this.current_index, this.current_index + this.max_number_of_items_on_a_page);
            console.log('next');
            this.current_page = this.current_page + 1;
        }
    }

    previous() {
        if (this.current_page > 1) {
            this.current_index -= this.max_number_of_items_on_a_page;
            this.temp_list = this.list.slice(this.current_index, this.current_index + this.max_number_of_items_on_a_page);
            console.log('previous');
            this.current_page = this.current_page - 1;
        }
    }

    get_mods() {
            const aUser = new Client(this.http);
            aUser.get_all_mods().subscribe(
                res => {
                    this.mods = res;
                    console.log(this.mods);
                },
                err => {
                    console.log(err);
                }
            );
    }

    send_report(tid, msgSub, msg, modid) {
        let aMsg = new Message(this.http);
        aMsg.subject = 'Concerning Trans#' + aMsg.transid;
        aMsg.responderid = 0;
        aMsg.senderid = parseInt(sessionStorage.getItem('userid'), 10);
        aMsg.content = msg;
        aMsg.post_new_report().subscribe(
            res => {
                console.log(res);
            },
            err => {
                console.log(err);
            }
        );
        console.log('send report');
    }
}


interface Post {
    OrderID: number;
    BuyerID: number;
    Status:string;
    TotalItems:number;
    OrderTimeStamp:string;
};

