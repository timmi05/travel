import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import 'rxjs/add/operator/toPromise';
import {User} from '../model/user';

@Injectable()
export class UserService {

    private usersUrl: string = 'travel/user';

    constructor(private http: Http) {
    }

    getUsers(): Promise<User[]> {
        return this.http.get(this.usersUrl)
            .toPromise()
            .then(responce => responce.json())
            .catch(this.handleError);
    }

    add(user: User) {
        const body = JSON.stringify({username: user.username, password: user.password, firstName: user.firstName,
            lastName: user.lastName, phoneNumber: user.phoneNumber, mail: user.mail});
        return this.http.post('travel/adduser', body).map(() => {
            return true;
        });
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }


}