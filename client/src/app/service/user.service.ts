import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers, Response} from "@angular/http";
import {Observable} from "rxjs";
import {User} from '../model/user';
import {LoginService} from "../authorization/login.service";

@Injectable()
export class UserService {

    private usersUrl: string = 'travel/registration';

    constructor(private http: Http) {
    }

    getUsers() {
        return this.http.get(this.usersUrl)
            .map((response: Response) => response.json())
            .catch(UserService.handleError);
    }

    getUser(username: String) {
        return this.http.get(this.usersUrl + '/' + username)
            .map((response: Response) => response.json())
            .catch(UserService.handleError);
    }

    registrationUser(user: User) {
        const body = user;
        return this.http.post(this.usersUrl, body).map(() => {
            return true;
        });
    }

    updateUser(user: User) {
        const body = user;
        const headers = new Headers({
            'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.usersUrl, body, options).map(() => {
            return true;
        });
    }

    private static handleError(error: any) {
        let errMsg: string;
        if (error instanceof Response) {
            const body = error.json() || '';
            const err = body.error || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText}`;
            errMsg += `${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Observable.throw(errMsg);
    }
}