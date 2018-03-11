import { Component, OnInit, Input, OnChanges, SimpleChanges, AfterContentInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {FormGroup, FormControl} from "@angular/forms";
import { ActivatedRoute } from '@angular/router';
import { Item } from '../../shared/models/item';

@Component({
    selector: 'app-reviews',
    templateUrl: './reviews.component.html',
    styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {

    list = [];
    reviews: any;
    is_review_display: boolean;
    temp_list: any[];
    max_number_of_items_on_a_page = 6;
    current_page = 1;
    last_page = 1;
    current_index = 0;

    @Input() canReview: boolean;
    @Input() reviewer: string;
    @Input() itemModel: Item;
    itemid: number;
    reviewTextModel: string;
    enteredText = true;
    form = new FormGroup({
        myRatingControl: new FormControl('5')
    });

    constructor(private http: HttpClient, private route: ActivatedRoute) { }

    load_list_information() {
        console.log('get information');
        try {
            let type;
            this.temp_list = [];
            this.is_review_display = true;
            this.apply_pagination();
        } catch (ex) {
            console.log(ex);
        }
    }

    ngOnInit() {
        this.load_list_information();
        this.route.params
            .subscribe(
            params => {
                this.itemid = +params['id']; // (+) converts string 'id' to number
            });
        this.get_reviews();
        console.log(this.reviews);
    }

    apply_pagination(){
        this.temp_list = this.list.slice(this.current_index, this.current_index + this.max_number_of_items_on_a_page);
        this.last_page = Math.ceil(this.list.length / this.max_number_of_items_on_a_page);

        if(this.last_page <= 0){
            this.last_page = 1;
        }
        console.log('temlist');
        console.log(this.temp_list);
    }

    next(){
        if(this.last_page > this.current_page){
            this.current_index += this.max_number_of_items_on_a_page;
            this.temp_list = this.list.slice(this.current_index, this.current_index + this.max_number_of_items_on_a_page);
            console.log('next');
            this.current_page = this.current_page + 1;
        }
    }

    previous() {
        if (this.current_page > 1) {
            this.current_index -= this.max_number_of_items_on_a_page;
            this.temp_list = this.list.slice(this.current_index, this.current_index + this.max_number_of_items_on_a_page);
            console.log('previous');
            this.current_page = this.current_page - 1;
        }
    }

    get_reviews() {
        let reviewItem = new Item(this.http);
        reviewItem.itemid = this.itemid;
        reviewItem.get_ratings().subscribe(
            res => {
                if(res != []) {
                    this.reviews = res;
                    this.list = this.reviews;
                }
            },
            err => {
                console.log(err);
            }
        );
    }

    add_review() {
        if (this.reviewTextModel !== '' && this.reviewTextModel != undefined) {
            console.log(this.reviewTextModel + ' :for: ' + this.itemModel.itemid);   
            console.log(this.form.value['myRatingControl']);
            this.itemModel.ratingavg = parseInt(this.form.value['myRatingControl'], 10);
            this.itemModel.ratingtext = this.reviewTextModel;
            this.itemModel.post_rating().subscribe(
                res => {
                    console.log(res);
                    window.location.reload();
                },
                err => {
                    console.log(err);
                }
            )
        } else {
            this.enteredText = false;
        }
    }
}
