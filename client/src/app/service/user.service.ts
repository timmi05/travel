import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import {User} from '../model/user';


@Injectable()
export class UserService {

    private usersUrl: string = 'travel/registration';

    constructor(private http: Http) {
    }

    registrationUser(user: User) {
        const body = user;
        return this.http.post(this.usersUrl, body).map(() => {
            return true;
        });
    }
}