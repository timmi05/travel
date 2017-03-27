import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers, Response} from "@angular/http";
import {Observable} from "rxjs";
import {Tour} from "../model/tour";
import {LoginService} from "../authorization/login.service";

@Injectable()
export class TourService {

    private tourUrl: string = 'travel/tour';

    constructor(private http: Http) {
    }

    getTours() {
        return this.http.get(this.tourUrl)
            .map((response: Response) => response.json())
            .catch(TourService.handleError);
    }

    findTours(tour: Tour) {
        const body = tour;
        return this.http.get(this.tourUrl, body)
            .map((response: Response) => response.json())
            .catch(TourService.handleError);
    }

    newTour(tour: Tour) {
        const body = tour;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.tourUrl, body, options).map(() => {
            return true;
        });
    }

    updateTour(tour: Tour) {
        const body = JSON.stringify({id : tour.id, booking : tour.booking, user : tour.user});
        const headers = new Headers({
            'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.tourUrl, body, options).map(() => {
            return true;
        });
    }

    updateTourByManager(tour: Tour) {
        const body = tour;
        const headers = new Headers({
            'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.tourUrl + 'bymanager', body, options).map(() => {
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