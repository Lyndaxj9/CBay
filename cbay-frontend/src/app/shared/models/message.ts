import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';

export class Message {
    messageid: number;
    threadid: number;
    transid: number;
    senderid: number;
    responderid: number;
    subject: string;
    content: string;
    timestamp: any;

    messageUrl = `http://localhost:8089/CBay_Project/rest/message`;

    constructor (public http: HttpClient) { }

    get_single_msg(id: number) {
        const req =
              this.http.get(this.messageUrl + '/get/' + id,
                            {headers: new HttpHeaders({
                                'Content-Type': 'application/json'
                            })});
        return req;
    }

    get_user_threads(userid: number) {
        const req = this.http.get(this.messageUrl + '/get/thread/' + userid, {headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })});
        return req;
    }

    get_thread_msg(thid: number) {
        const req = this.http.get(this.messageUrl + '/get/thread/msg/' + thid, {headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })});
        return req;
    }

    post_new_report() {
        const req = this.http.post(this.messageUrl + '/post/report', {
            transaction: this.transid,
            sender: this.senderid,
            responder: this.responderid,
            content: this.content,
            subject: this.subject
        }, {responseType: 'text'});

        return req;
    }

    post_new_msg() {
        const req = this.http.post(this.messageUrl + '/post', {
            thread: this.threadid,
            transaction: this.transid,
            sender: this.senderid,
            responder: this.responderid,
            content: this.content,
            subject: this.subject
        }, {responseType: 'text'});

        return req;
    }
}
