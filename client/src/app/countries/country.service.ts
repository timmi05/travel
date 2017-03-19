import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import 'rxjs/add/operator/toPromise';
import {Country} from '../model/country';

@Injectable()
export class CountryService{

private countriesUrl: string = '/travel/country';

    constructor(private http: Http) { }

    getCountries(): Promise<Country[]> {
        return this.http.get(this.countriesUrl)
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