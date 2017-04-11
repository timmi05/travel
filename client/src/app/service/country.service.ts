import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers, Response} from "@angular/http";
import {Country} from '../model/country';
import {LoginService} from "../authorization/login.service";

@Injectable()
export class CountryService {

    private countriesUrl: string = '/travel/country';

    constructor(private http: Http) {
    }

    loadCountries() {
        return this.http.get(this.countriesUrl)
            .map((response: Response) => {
                if (response.status != 200) {
                    throw new Error('Error while loading all entities! code status: ' + response.status);
                } else {
                    return response.json();
                }
            })
    }

    add(country: Country) {
        const body = country;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.countriesUrl, body, options).map((response: Response) => response.status === 201);
    }

    update(country: Country) {
        const body = country;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.countriesUrl, body, options).map((response: Response) => response.status === 200);
    }
}
