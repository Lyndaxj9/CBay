import { HttpClient, HttpHeaders } from '@angular/common/http';

export class Client {
    userid: number;
    firstname: string;
    lastname: string;
    usertype: string;
    username: string;
    password: string;
    email: string;
    rating: number;
    description: string;
    user: Object;
    // userUrl = `http://localhost:8089/CBay_Project/rest/user/get`;
    userUrl = `http://54.213.131.230:8089/CBay/rest/user/get`;

    constructor (public http: HttpClient) { }

    set_all_values(userInfo: any) {
        this.userid = userInfo.id;
        this.username = userInfo.userName;
        this.usertype = userInfo.userType;
        this.firstname = userInfo.firstName;
        this.lastname = userInfo.lastName;
        this.email = userInfo.email;
        this.password = userInfo.PW;
    }

    get(id: any): Promise<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type':  'application/json'
            })
        };
        return this.http.get(this.userUrl + '/' + id, httpOptions)
            .toPromise();
    }

    get_format_for_entity(id: any) {
        this.get(id).then(user_data => {
         /*   let userID;
            let name;
            let editAble = {};
            let nonEditable = {};
            this.password = user_data['PW'];

            // delete user_data['PW'];

            userID = user_data['id'];
            name = user_data['userName'];
            editAble['First Name'] = user_data['firstName'];
            editAble['Last Name'] = user_data['lastName'];
            editAble['e-mail'] = user_data['email'];
            nonEditable['User Type'] = user_data['userType'];

            // TODO how to get this as an accessable object
            this.user = {
                id: userID,
                name: name,
                editAble: editAble,
                nonEditable: nonEditable
            };*/

            console.log('in client model: ' + user_data);
            return user_data;
        }).catch(error => {
            console.log(error);
            return null;
        });
    }
}

