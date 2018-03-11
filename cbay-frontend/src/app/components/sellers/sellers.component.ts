import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Title} from '@angular/platform-browser';
import {Router} from '@angular/router';
import {Client} from '../../shared/models/client';
import {Item} from '../../shared/models/item';
import {Url} from '../../shared/models/url';

@Component({
  selector: 'app-sellers',
  templateUrl: './sellers.component.html',
  styleUrls: ['./sellers.component.css']
})
export class SellersComponent implements OnInit {

  private list: Post[];
  is_user_display: boolean;
  private temp_list: Post[];
  max_number_of_items_on_a_page = 6;
  current_page = 1;
  last_page = 1;
  current_index = 0;
  item: Item;
  url = new Url();

  constructor(private http: HttpClient, private router: Router, private titleService: Title) {}


  view_user(l) {
    console.log(l);
    this.router.navigate(['profile/', l.id]).catch(error => {
      console.log(error);
    });
  }

  ngOnInit() {
    this.titleService.setTitle('Users');

    this.item = new Item(this.http);
    this.list = [];
    this.temp_list = [];
    this.is_user_display = true;
    this.http.get<Post[]>(this.url.get_urlbase() + '/user/get/sell').subscribe(res => {
      console.log(res);
      let size = res.length;
      let i = 0;
      const user_id = Number.parseInt(sessionStorage.getItem('userid'));
      console.log(user_id);

      res.forEach(item => {
        this.list.push(item);
        console.log(item);


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
    
    approve_seller(sid) {
        console.log('approve: ' + sid);
        let userModel = new Client(this.http);
        userModel.userid = sid;
        userModel.approve_account().subscribe(
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

interface Post {
  firstname: string;
  lastname: number;
  usertype:string;
  username:number;
  email:number;
  description:number;
};


