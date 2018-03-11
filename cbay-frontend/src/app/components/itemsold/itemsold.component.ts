import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Title} from '@angular/platform-browser';
import {Router} from '@angular/router';
import {Item} from '../../shared/models/item';
import {Order} from '../../shared/models/order';
import {Url} from '../../shared/models/url';

@Component({
    selector: 'app-itemsold',
    templateUrl: './itemsold.component.html',
    styleUrls: ['./itemsold.component.css']
})
export class ItemsoldComponent implements OnInit {

    private list: any[];
    is_item_display: boolean;
    private temp_list: Post[];
    max_number_of_items_on_a_page = 6;
    current_page = 1;
    last_page = 1;
    current_index = 0;
    item: Item;
    url = new Url();

    status = ['Shipped', 'Canceled', 'Delivered'];

    constructor(private http: HttpClient, private router: Router, private titleService: Title) {}


    view_item(id) {
        this.router.navigate(['item/', id]).catch(error => {
            console.log(error);
        });
    }

    ngOnInit() {
        this.titleService.setTitle('My Stores');

        this.item = new Item(this.http);
        this.list = [];
        this.temp_list = [];
        this.is_item_display = true;
        const user_id = Number.parseInt(sessionStorage.getItem('userid'));
        console.log(this.url.get_urlbase() + '/order/get/all/sellers/trans/' + user_id);
        let size = 0;
        this.http.get<any[]>(this.url.get_urlbase() + '/order/get/all/sellers/trans/' + user_id).subscribe(res => {
            console.log(res);
            let i = 0;
            size = res.length;
            res.forEach(items => {
                this.http.get<Post[]>(this.url.get_urlbase() + '/item/get/' + items.itemId).subscribe(response => {
                    console.log(response);
                    response['quantity'] = res[i].quantity;
                    response['transid'] = res[i].id;
                    response['status'] = res[i].status;
                    console.log(res[i].status);
                    i = i + 1;
                    this.list.push(response);
                    if(size <= i && this.list)
                    {
                        this.temp_list = this.list.slice(0, this.max_number_of_items_on_a_page);
                        this.last_page = Math.ceil(this.list.length / this.max_number_of_items_on_a_page);
                    }
                });
            });

        });

    }

    next(){
        if(this.last_page > this.current_page){
            this.current_index += this.max_number_of_items_on_a_page;
            this.temp_list = this.list.slice(this.current_index, this.current_index + this.max_number_of_items_on_a_page);
            console.log('next');
            this.current_page = this.current_page + 1;
        }
    }

    previous(){
        if(this.current_page > 1){
            this.current_index -= this.max_number_of_items_on_a_page;
            this.temp_list = this.list.slice(this.current_index, this.current_index + this.max_number_of_items_on_a_page);
            console.log('previous');
            this.current_page = this.current_page - 1;
        }
    }

    update_status(tid, tstatusChange) {
        console.log(tid);
        let orderModel = new Order(this.http);
        orderModel.transid = tid;

        if (tstatusChange === 'Shipped') {
            orderModel.update_trans_shipped().subscribe(
                res => {
                    console.log(res);
                    window.location.reload();
                },
                err => {
                    console.log(err);
                }
            );
        } else if (tstatusChange === 'Delivered') {
            orderModel.update_trans_delivered().subscribe(
                res => {
                    console.log(res);
                    window.location.reload();
                },
                err => {
                    console.log(err);
                }
            );
        } else if (tstatusChange === 'Canceled') {
            orderModel.update_trans_canceled().subscribe(
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

}

interface Post {
    description?: string;
    id: number;
    itemName: string;
    price: number;
    quantity: number;
    ratingAvg: number;
    userId: number;
    transid: number;
    status: string;
    statusChange: string;
};
