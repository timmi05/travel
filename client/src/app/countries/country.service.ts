import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers} from "@angular/http";
import 'rxjs/add/operator/toPromise';
import {Country} from '../model/country';
import {LoginService} from "../authorization/login.service";

@Injectable()
export class CountryService{

private countriesUrl: string = '/travel/country';

    constructor(private http: Http) { }

    getCountries(): Promise<Country[]> {
        const headers = new Headers({'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token});
        const options = new RequestOptions({headers: headers});
        return this.http.get(this.countriesUrl, options)
            .toPromise()
            .then(responce => responce.json())
            .catch(this.handleError);
    }

    addcountry(country: Country){
        const body = JSON.stringify({name: country.name});
        return this.http.post('travel/addcountry', body).map(() => {
            return true;
        });
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }



}