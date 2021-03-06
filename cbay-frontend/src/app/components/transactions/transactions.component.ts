import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  list = ['', '', '', '', '', '', '', '', '' , ''];
  is_transaction_display:boolean;
  temp_list:any[];
  max_number_of_items_on_a_page = 6;
  current_page = 1;
  last_page = 1;
  current_index = 0;

  load_list_information(){
    console.log('get information');
    try
    {
      let type;
      this.temp_list = [];
      this.is_transaction_display = true;
      this.apply_pagination();
    }
    catch(ex)
    {
      console.log(ex);
    }
  }

    constructor(private titleService: Title) { }

  ngOnInit() {
      this.titleService.setTitle('Transactions');
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
