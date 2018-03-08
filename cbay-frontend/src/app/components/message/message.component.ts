import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Message } from '../../shared/models/message';

@Component({
    selector: 'app-message',
    templateUrl: './message.component.html',
    styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
    messageModel: Message;
    messages: any;

    constructor(public http: HttpClient) { }

    ngOnInit() {
        this.messageModel = new Message(this.http);

        this.messageModel.get_thread_msg(1001).subscribe(
            res => {
                this.messages = res;
                this.messageModel.transid = res[0]['transaction'];
                this.messageModel.threadid = res[0]['threadID'];
                this.messageModel.responderid = res[0]['responder'];
                this.messageModel.subject = res[0]['subject'];
                console.log(res);
            },
            err => {
                console.log(err);
            }
        );
    }
    
    format_date() {
        // TODO make date/timestamp better looking
    }

    onSend() {
        console.log('send message ' + this.messageModel.content + ' to db');
        this.messageModel.senderid = parseInt(sessionStorage.getItem('userid'));
        this.messageModel.post_new_msg().subscribe(
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
