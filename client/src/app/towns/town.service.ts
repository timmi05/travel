import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import 'rxjs/add/operator/toPromise';
import {Town} from '../model/town';

@Injectable()
export class TownService{

private townsUrl: string = 'travel/town';

    constructor(private http: Http) { }

    getTowns(): Promise<Town[]> {
        return this.http.get(this.townsUrl)
            .toPromise()
            .then(responce => responce.json())
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }



}