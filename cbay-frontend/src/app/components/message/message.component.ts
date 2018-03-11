import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Title } from '@angular/platform-browser';
import { Message } from '../../shared/models/message';
import { Client } from '../../shared/models/client';

@Component({
    selector: 'app-message',
    templateUrl: './message.component.html',
    styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
    messageModel: Message;
    admins: any;
    messages: any;
    generalmsg: string;
    msgto: number;
    userid = sessionStorage.getItem('userid');
    usertype = sessionStorage.getItem('usertype');
    MOD = 'moderator';
    aMod = false;
    modtoadminmsg: string;
    adminSelect: number;

    constructor(public http: HttpClient, private titleService: Title) { }

    ngOnInit() {
        this.titleService.setTitle('Message Thread');

        this.messageModel = new Message(this.http);
        this.messageModel
            .get_thread_msg(parseInt(localStorage.getItem('msgthread'), 10))
            .subscribe(
            res => {
                this.messages = res;
                this.messageModel.transid = res[0]['transaction'];
                this.messageModel.threadid = res[0]['threadID'];
                if (res[0]['responder'] === parseInt(this.userid, 10)) {
                    this.msgto = res[0]['responder'];
                } else {
                    this.msgto = res[0]['responder'];
                }
                this.messageModel.subject = res[0]['subject'];
                console.log(res);
            },
            err => {
                console.log(err);
            }
        );

        this.aMod = this.usertype === this.MOD;
        if (this.aMod) {
            const aUser = new Client(this.http);
            aUser.get_all_admins().subscribe(
                res => {
                    this.admins = res;
                    console.log(this.admins);
                },
                err => {
                    console.log(err);
                }
            );
        }
    }

    format_date() {
        // TODO make date/timestamp better looking
    }

    onSend() {
        console.log('send message ' + this.messageModel.content + ' to db');
        this.messageModel.responderid = this.msgto;
        console.log("onSend() msgto: " + this.msgto);
        this.messageModel.senderid = parseInt(sessionStorage.getItem('userid'), 10);
        this.messageModel.content = this.generalmsg;
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

    escalate() {
        this.messageModel.subject = 'Concerning Trans#' + this.messageModel.transid;
        this.messageModel.responderid = this.adminSelect;
        this.messageModel.senderid = parseInt(sessionStorage.getItem('userid'), 10);
        this.messageModel.content = this.modtoadminmsg;
        this.messageModel.post_new_report().subscribe(
            res => {
                console.log(res);
            },
            err => {
                console.log(err);
            }
        );
    }

}
