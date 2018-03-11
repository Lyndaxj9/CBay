import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { Item } from '../../shared/models/item';

@Component({
    selector: 'app-additem',
    templateUrl: './additem.component.html',
    styleUrls: ['./additem.component.css']
})
export class AdditemComponent {
    itemModel: Item;
    itemId: number;
    model = new Tmp('', '', 0, 0);

    submitted = false;

    constructor(public http: HttpClient, private router: Router, private titleService: Title) { }

    onSubmit() {
        this.titleService.setTitle('Add Item');

        this.submitted = false;
        this.itemModel = new Item(this.http);
        this.itemModel.userid = parseInt(sessionStorage.getItem('userid'), 10);
        this.itemModel.itemname = this.model.name;
        this.itemModel.description = this.model.description;
        this.itemModel.price = this.model.price;
        this.itemModel.quantity = this.model.quantity;
        this.itemModel.post().subscribe(
            res => {
                this.itemId = parseInt(res, 10);
                console.log(this.itemId);
                this.router.navigate(['/item', this.itemId]);
            },
            err => {
                console.log(err);
            }
        );
    }

    // TODO: Remove this when we're done
    get diagnostic() { return JSON.stringify(this.model); }

    reset() {
        this.model = new Tmp('', '', 0, 0);
    }

}

export class Tmp {
    constructor(
    public name: string,
     public description: string,
     public price: number,
     public quantity: number
    ) {  }

}
