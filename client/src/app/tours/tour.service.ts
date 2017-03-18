import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import 'rxjs/add/operator/toPromise';
import {Tour} from "../model/tour";

@Injectable()
export class TourService{

private tourUrl: string = 'travel/hotel';

    constructor(private http: Http) { }

    getTours(): Promise<Tour[]> {
        return this.http.get(this.tourUrl)
            .toPromise()
            .then(responce => responce.json())
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }



}