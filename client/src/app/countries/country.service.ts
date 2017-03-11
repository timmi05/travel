import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import 'rxjs/add/operator/toPromise';
import {Country} from './country';

@Injectable()
export class CountryService{

private countriesUrl: string = 'travel/country';

    constructor(private http: Http) { }

    getCountries(): Promise<Country[]> {
        return this.http.get(this.countriesUrl)
            .toPromise()
            .then(responce => responce.json())
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }



}