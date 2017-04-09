import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers, Response} from "@angular/http";
// import {Observable} from "rxjs";
import {Tour} from "../model/tour";
import {LoginService} from "../authorization/login.service";
import {User} from "../model/user";

@Injectable()
export class TourService {

    private tourUrl: string = 'travel/tour';
    private toursUrl: string = 'travel/tours';
    private managertoursUrl: string = 'travel/managertours';
    private bookingUrl: string = 'travel/booking';
    private updateUrl: string = 'travel/updatetour';
    private myUrl: string = 'travel/mytour';

    constructor(private http: Http) {
    }

    getTours(user: User) {
        const body = user;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.myUrl, body, options).map((response: Response) => response.json());
    }

    findTours(tour: Tour) {
        const body = tour;
        return this.http.post(this.toursUrl, body)
            .map((response: Response) => response.json());
    }

    findToursForManager(tour: Tour) {
        const body = tour;
        return this.http.post(this.managertoursUrl, body)
            .map((response: Response) => response.json());
    }

    newTour(tour: Tour) {
        const body = tour;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.tourUrl, body, options).map((response: Response) => response.status === 201);
    }

    bookingTour(tour: Tour) {
        const body = JSON.stringify({id : tour.id, booking : tour.booking, user : tour.user});
        const headers = new Headers({
            'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.bookingUrl, body, options).map((response: Response) => response.status === 200);
    }

    unBookingTour(tour: Tour) {
        const body = tour;
        const headers = new Headers({
            'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.bookingUrl, body, options).map((response: Response) => response.status === 200);
    }

    update(tour: Tour) {
        const body = tour;
        const headers = new Headers({
            'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.updateUrl, body, options).map(() => {
            return true;
        });
    }

    // private static handleError(error: any) {
    //     let errMsg: string;
    //     if (error instanceof Response) {
    //         const body = error.json() || '';
    //         const err = body.error || JSON.stringify(body);
    //         errMsg = `${error.status} - ${error.statusText}`;
    //         errMsg += `${err}`;
    //     } else {
    //         errMsg = error.message ? error.message : error.toString();
    //     }
    //     console.error(errMsg);
    //     return Observable.throw(errMsg);
    // }
}