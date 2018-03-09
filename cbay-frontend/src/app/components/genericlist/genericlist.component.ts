import { Component, DoCheck } from '@angular/core';
@Component({
  selector: 'app-genericlist',
  templateUrl: './genericlist.component.html',
  styleUrls: ['./genericlist.component.css']
})
export class GenericlistComponent implements  DoCheck{
  list = ['', '', '', '', '', '', '', '', '' , ''];
  is_user_display:boolean;
  is_cart_display:boolean;
  is_item_display:boolean;
  is_transaction_display:boolean;
  is_review_display:boolean;
  temp_list:any[];
  max_number_of_items_on_a_page = 6;
  current_page = 1;
  last_page = 1;
  current_index = 0;
  constructor() { }


  DoCheck(){
    let type;
    this.temp_list = [];
    this.is_user_display = false;
    this.is_cart_display = false;
    this.is_item_display = false;
    this.is_transaction_display = false;
    this.is_review_display = false;
    try
    {
      type = sessionStorage.getItem('list_type');
      switch(type){
        case 'item':
          this.is_item_display = true;
          this.apply_pagination();
          break;
        case 'user':
          this.is_user_display = true;
          this.apply_pagination();
          break;
        case 'transaction':
          this.is_transaction_display = true;
          this.apply_pagination();
          break;
        case 'review':
          this.is_review_display = true;
          this.apply_pagination();
          break;
        case 'cart':
          this.is_cart_display = true;
          this.apply_pagination();
          break;
        default:
          console.log('nothing found');
      }
    }
    catch(ex)
    {
      console.log(ex);
    }

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
