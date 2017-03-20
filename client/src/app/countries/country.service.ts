import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers, Response} from "@angular/http";
import {Country} from '../model/country';
import {Observable} from "rxjs";
import {LoginService} from "../authorization/login.service";

@Injectable()
export class CountryService{

private countriesUrl: string = '/travel/country';

    constructor(private http: Http) { }

    getCountries() {
        return this.http.get(this.countriesUrl)
            .map((response: Response) => response.json())
            .catch(CountryService.handleError);
    }

    addcountry(country: Country){
        const body = country;
        const headers = new Headers({'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token});
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.countriesUrl, body, options).map(() => {
            return true;
        });
    }

    updatecountry(country: Country){
        const body = country;
        const headers = new Headers({'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token});
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.countriesUrl, body, options).map(() => {
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
