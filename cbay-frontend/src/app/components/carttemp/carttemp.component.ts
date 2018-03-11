import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Item } from '../../shared/models/item';
import { Order } from '../../shared/models/order';
import {Router} from '@angular/router';
import {Url} from '../../shared/models/url';

@Component({
    selector: 'app-carttemp',
    templateUrl: './carttemp.component.html',
    styleUrls: ['./carttemp.component.css']
})
export class CarttempComponent implements OnInit {

  private list: Post[];
  is_item_display: boolean;
  private temp_list: Post[];
  max_number_of_items_on_a_page = 6;
  current_page = 1;
  last_page = 1;
  current_index = 0;
  item: Item;
  url = new Url();

  constructor(private http: HttpClient, private router: Router) {}


  view_item(id) {
    this.router.navigate(['item/', id]).catch(error => {
      console.log(error);
    });
  }

  ngOnInit() {
    this.item = new Item(this.http);
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

      res.forEach(item => {
        if(user_id===item.BuyerID)
        {
          this.list.push(item);
          console.log(item);
        }

        i = i + 1;
        if(size <= i && this.list)
        {
          this.temp_list = this.list.slice(0, this.max_number_of_items_on_a_page);
          this.last_page = Math.ceil(this.list.length / this.max_number_of_items_on_a_page);
        }
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

}

interface Post {
  OrderID: number;
  BuyerID: number;
  Status:string;
  TotalItems:number;
  OrderTimeStamp:string;
};
