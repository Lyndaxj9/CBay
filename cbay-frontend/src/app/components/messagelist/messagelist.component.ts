import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Message } from '../../shared/models/message';

@Component({
    selector: 'app-messagelist',
    templateUrl: './messagelist.component.html',
    styleUrls: ['./messagelist.component.css']
})
export class MessagelistComponent implements OnInit {
    messageModel: Message;
    messageThreads: Object;

    constructor(public http: HttpClient) { }

    ngOnInit() {
        this.messageModel = new Message(this.http);
        this.messageModel
        .get_user_threads(parseInt(sessionStorage.getItem('userid'), 10))
            .subscribe(
            res => {
                this.messageThreads = res;
            },
            err => {
                console.log(err);
            }
        );
    }

    set_msg(event) {
        console.log(event.target.name);
        localStorage.setItem('msgthread', event.target.name);
        window.location.replace('/messages/thread');
    }
}
