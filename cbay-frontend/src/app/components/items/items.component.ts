import { Component, OnInit } from '@angular/core';
import { Item } from '../../shared/models/item';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Url } from '../../shared/models/url';
@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  list: Post[];
  is_item_display: boolean;
  temp_list: Post[];
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
    this.is_item_display = true;
    this.http.get<Post[]>(this.url.get_urlbase() + '/item/get/all').subscribe(res => {
      console.log(res);
      let size = res.length;
      let i = 0;
      res.forEach(item=>{
        this.list.push(item);
        console.log(item.description);
        console.log(item.id);
        console.log(item.itemName);
        console.log(item.price);
        console.log(item.quantity);
        console.log(item.ratingAvg);
        console.log(item.userId);
        i = i + 1;
        if(size <= i){
          this.temp_list = this.list.slice(0, this.max_number_of_items_on_a_page);
          this.last_page = Math.ceil(this.list.length/this.max_number_of_items_on_a_page);
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
  description: string;
  id: number;
  itemName:string;
  price:number;
  quantity:number;
  ratingAvg:number;
  userId:number;
};
