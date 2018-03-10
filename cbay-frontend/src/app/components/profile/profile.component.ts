import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Client } from '../../shared/models/client';
import { Router } from '@angular/router';

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
    userId: number;
    currentUser: number;
    private sub: any;

    clientModel: Client;
    buyerOptions = [
        {
            name: 'Messages',
            link: '/messages'
        },
        {
            name: 'Cart',
            link: '/cart'
        },
        {
            name: 'Previous Orders',
            link: 'list/orders'
        }
    ];
    sellerOptions = [
        {
            name: 'Messages',
            link: '/messages'
        },
        {
            name: 'Sell Item',
            link: '/profile/' + sessionStorage.getItem('userid') + '/additem' // sellitem
        },
        {
            name: 'Sold Items',
            link: 'list/item' // solditems
        },
        {
            name: 'All Items',
            link: 'list/item' // allitems
        }
    ];
    modOptions = [
        {
            name: 'Messages',
            link: '/messages'
        },
        {
            name: 'Approve Sellers',
            link: 'list/user' // approvesellers
        }
    ];
    adminOptions = [
        {
            name: 'Messages',
            link: '/messages'
        },
        {
            name: 'Approve Mods',
            link: '/list/user' // approvemods
        },
        {
            name: 'All Users',
            link: 'http://localhost:4200/cbay/list/user' // allusers
        },
        {
            name: 'All Transactions',
            link: '/list/transaction' // alltransactions
        }
    ];
    options: Array<Object>;

    constructor(public http: HttpClient, private route: ActivatedRoute, public router: Router) {
        this.sub = this.route.params
            .subscribe(params => {
            this.userId = +params['id'];
            this.get_user_info();
        });
    }

    ngOnInit() { }

    get_user_info() {
        this.currentUser = parseInt(sessionStorage.getItem('userid'), 10);
        this.clientModel = new Client(this.http);
        this.clientModel.get(this.userId)
            .then(user_data => {

            this.clientModel.set_all_values(user_data);
            console.log(this.clientModel);
        }).catch(error => {
            console.log(error);
        });
        console.log(sessionStorage.getItem('usertype'));
        if (sessionStorage.getItem('usertype') === 'buyer') {
            this.options = this.buyerOptions;
        } else if (sessionStorage.getItem('usertype') === 'seller') {
            this.options = this.sellerOptions;
        } else if (sessionStorage.getItem('usertype') === 'moderator') {
            this.options = this.modOptions;
        } else if (sessionStorage.getItem('usertype') === 'admin') {
            this.options = this.adminOptions;
        }
    }

  handle_link(o) {
      console.log(o);
      this.router.navigateByUrl(o.link);
  }
}
