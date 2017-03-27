import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers, Response} from "@angular/http";
import {Observable} from "rxjs";
import {Town} from '../model/town';
import {LoginService} from "../authorization/login.service";
import {Country} from "../model/country";

@Injectable()
export class TownService {

    private townsUrl: string = 'travel/town';

    constructor(private http: Http) {
    }

    getTowns() {
        return this.http.get(this.townsUrl)
            .map((response: Response) => response.json())
            .catch(TownService.handleError);
    }

    findTownsByCountry(country :Country) {
        const body = country;
        return this.http.get(this.townsUrl + 'incountry', body)
            .map((response: Response) => response.json())
            .catch(TownService.handleError);
    }

    newTown(town: Town) {
        const body = town;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.townsUrl, body, options).map((response: Response) => response.status === 201);
    }

    updateTown(town: Town) {
        const body = town;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.townsUrl, body, options).map((response: Response) => response.status === 200);
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
