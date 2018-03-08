import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-genericlist',
  templateUrl: './genericlist.component.html',
  styleUrls: ['./genericlist.component.css']
})
export class GenericlistComponent implements OnInit {
  list = ['', '', '', '', '', '', '', '', '' , ''];
  is_user_display = false;
  is_cart_display = false;
  is_item_display = false;
  is_transaction_display = false;
  is_review_display = false;
  temp_list = [];
  max_number_of_items_on_a_page = 6;
  current_page = 1;
  last_page = 1;
  current_index = 0;
  constructor() { }

  ngOnInit() {
    this.is_item_display = false;
    this.is_user_display = false;
    this.is_transaction_display = true;
    this.is_review_display = false;
    this.is_cart_display = false;
    //-- get list of information
    //-- and add it to temp list
    //-- that will display the items.
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
