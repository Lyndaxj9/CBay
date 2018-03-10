import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Item } from '../../shared/models/item';
import { Order } from '../../shared/models/order';

@Component({
    selector: 'app-carttemp',
    templateUrl: './carttemp.component.html',
    styleUrls: ['./carttemp.component.css']
})
export class CarttempComponent implements OnInit {
    list = [];
    is_cart_display:boolean;
    temp_list = [];
    max_number_of_items_on_a_page = 6;
    current_page = 1;
    last_page = 1;
    current_index = 0;

    // --
    orderModel: Order;
    itemModel: Item;
    total = 0;

    transactions: any;
    currentCart: Array<Item>;
    // --

    constructor(public http: HttpClient) { }

    ngOnInit() {
        this.orderModel = new Order(this.http);
        this.orderModel.buyerid = parseInt(sessionStorage.getItem('userid'), 10);
        this.itemModel = new Item(this.http);
        this.currentCart = new Array();

        this.orderModel.get_cart().subscribe(
            res => {

                new Promise<any>(resolve=>{
                    this.transactions = res;
                    console.log(res);
                    this.getItemInfo();
                    console.log(this.currentCart);
                    console.log('currentCart');
                    console.log(this.currentCart);
                    this.list = this.currentCart;
                    resolve(this.list);
                }).then(result => {
                    this.apply_pagination();//
                    console.log('result');
                    console.log(result);
                })

                

            },
            err => {
                console.log(err);
            }
        );
    }

    apply_pagination(){
        this.temp_list = this.list.slice(this.current_index, this.current_index + this.max_number_of_items_on_a_page);
        this.last_page = Math.ceil(this.list.length / this.max_number_of_items_on_a_page);

        if(this.last_page <= 0){
            this.last_page = 1;
        }
        console.log('apply_pagi');
        console.log(this.temp_list);
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

    load_list_information(){
        console.log('get information');
        let type;
        this.temp_list = [];
        this.is_cart_display = false;

        try
        {
            type = sessionStorage.getItem('list_type');
            this.is_cart_display = true;
            this.apply_pagination();
        }
        catch(ex)
        {
            console.log(ex);
        }


    }

    // -- 
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
    // --

}
