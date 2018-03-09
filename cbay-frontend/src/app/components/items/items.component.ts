import { Component, OnInit } from '@angular/core';
import { Item } from '../../shared/models/item';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {
  constructor(private http:HttpClient, private router:Router){}

  list:any[];
  is_item_display:boolean;
  temp_list:any[];
  max_number_of_items_on_a_page = 6;
  current_page = 1;
  last_page = 1;
  current_index = 0;
  item: Item;

  load_list_information(){
    console.log('get information');
    try
    {
      this.temp_list = [];
      this.is_item_display = true;
      this.apply_pagination();
    }
    catch(ex)
    {
      console.log(ex);
    }
  }

  view_item(id){
    console.log(id);
    this.router.navigate(['item/', id]).catch(error=> {
      console.log(error);
    });
  }

  ngOnInit() {
    this.item = new Item(this.http);
    this.item.get_all_items().subscribe(items=>{
      this.temp_list = items;
    });
  this.load_list_information();
  }

  apply_pagination(){
    this.temp_list = this.list.slice(this.current_index, this.current_index + this.max_number_of_items_on_a_page);
    this.last_page = Math.ceil(this.list.length / this.max_number_of_items_on_a_page);

    if(this.last_page <= 0){
      this.last_page = 1;
    }
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
