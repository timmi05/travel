import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers, Response} from "@angular/http";
import {Town} from '../model/town';
import {LoginService} from "../authorization/login.service";

@Injectable()
export class TownService {

    private townsUrl: string = 'travel/town';

    constructor(private http: Http) {
    }

    loadTowns() {
        return this.http.get(this.townsUrl)
            .map((response: Response) => {
                if (response.status != 200) {
                    throw new Error('Error while loading all entities! code status: ' + response.status);
                } else {
                    return response.json();
                }
            })
    }

    add(town: Town) {
        const body = town;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.townsUrl, body, options).map((response: Response) => response.status === 201);
    }

    update(town: Town) {
        const body = town;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.townsUrl, body, options).map((response: Response) => response.status === 200);
    }
}
