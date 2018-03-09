import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  list = ['', '', '', '', '', '', '', '', '' , ''];
  is_order_display:boolean;
  temp_list:any[];
  max_number_of_items_on_a_page = 6;
  current_page = 1;
  last_page = 1;
  current_index = 0;

  load_list_information(){
    console.log('get information');
    let type;
    this.temp_list = [];
    this.is_order_display = false;

    try
    {
      type = sessionStorage.getItem('list_type');
      this.is_order_display = true;
      this.apply_pagination();
    }
    catch(ex)
    {
      console.log(ex);
    }


  }

  constructor() { }

  ngOnInit() {
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
