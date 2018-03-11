import { Component, OnInit, Input } from '@angular/core';
import {FormGroup, FormControl} from "@angular/forms";
import { Item } from '../../shared/models/item';

@Component({
    selector: 'app-reviews',
    templateUrl: './reviews.component.html',
    styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {

    list = ['', '', '', '', '', '', '', '', '' , ''];
    is_review_display: boolean;
    temp_list: any[];
    max_number_of_items_on_a_page = 6;
    current_page = 1;
    last_page = 1;
    current_index = 0;

    @Input() canReview: boolean;
    @Input() reviewer: string;
    @Input() itemModel: Item;
    reviewTextModel: string;
    enteredText = true;
    form = new FormGroup({
        myRatingControl: new FormControl('5')
    });

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
        // this.form.valid.myRatingControl
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

    previous() {
        if (this.current_page > 1) {
            this.current_index -= this.max_number_of_items_on_a_page;
            this.temp_list = this.list.slice(this.current_index, this.current_index + this.max_number_of_items_on_a_page);
            console.log('previous');
            this.current_page = this.current_page - 1;
        }
    }

    add_review() {
        if (this.reviewTextModel !== '' && this.reviewTextModel != undefined) {
            console.log(this.reviewTextModel);   
            console.log(this.form.value['myRatingControl']);
            this.itemModel.ratingavg = parseInt(this.form.value['myRatingControl'], 10);
            this.itemModel.ratingtext = this.reviewTextModel;
            this.itemModel.post_rating().subscribe(
                res => {
                    console.log(res);
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
