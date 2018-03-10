import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {Item} from '../../shared/models/item';

@Component({
  selector: 'app-itemsearch',
  templateUrl: './itemsearch.component.html',
  styleUrls: ['./itemsearch.component.css']
})
export class ItemsearchComponent implements OnInit {

  private list: Post[];
  is_item_display: boolean;
  private temp_list: Post[];
  max_number_of_items_on_a_page = 6;
  current_page = 1;
  last_page = 1;
  current_index = 0;
  item: Item;

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
    this.http.get<Post[]>('http://54.213.131.230:8089/CBay/rest/item/get/all').subscribe(res => {
      console.log(res);
      let size = res.length;
      let i = 0;
      const user_id = Number.parseInt(sessionStorage.getItem('userid'));
      console.log(user_id);

      res.forEach(item => {
        if(user_id===item.userId){
          this.list.push(item);
          console.log(item);
        }

        i = i + 1;
        if(size <= i && this.list){
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
  description: string;
  id: number;
  itemName:string;
  price:number;
  quantity:number;
  ratingAvg:number;
  userId:number;
};
