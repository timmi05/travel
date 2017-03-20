import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers, Response} from "@angular/http";
import {Observable} from "rxjs";
import {Town} from '../model/town';
import {LoginService} from "../authorization/login.service";

@Injectable()
export class TownService{

private townsUrl: string = 'travel/town';

    constructor(private http: Http) { }

    getTowns() {
        return this.http.get(this.townsUrl)
            .map((response: Response) => response.json())
            .catch(TownService.handleError);
    }

    addtown(town: Town){
        const body = town;
        const headers = new Headers({'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token});
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.townsUrl, body, options).map(() => {
            return true;
        });
    }

    updatetown(town: Town){
        const body = town;
        const headers = new Headers({'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token});
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.townsUrl, body, options).map(() => {
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
