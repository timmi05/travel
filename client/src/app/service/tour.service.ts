import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers, Response} from "@angular/http";
import {Tour} from "../model/tour";
import {LoginService} from "../authorization/login.service";
import {User} from "../model/user";

@Injectable()
export class TourService {

    private tourUrl: string = 'travel/tour';
    private toursUrl: string = 'travel/tours';
    private managerToursUrl: string = 'travel/managertours';
    private bookingUrl: string = 'travel/booking';
    private myUrl: string = 'travel/mytours';

    constructor(private http: Http) {
    }

    loadUsersTours(user: User) {
        const body = user;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.myUrl, body, options)
            .map((response: Response) => {
                if (response.status != 200) {
                    throw new Error('Error while loading all entities! code status: ' + response.status);
                } else {
                    return response.json();
                }
            })
    }

    findTours(tour: Tour) {
        const body = tour;
        return this.http.post(this.toursUrl, body)
            .map((response: Response) => {
                if (response.status != 200) {
                    throw new Error('Error while loading all entities! code status: ' + response.status);
                } else {
                    return response.json();
                }
            })
    }

    findToursForManager(tour: Tour) {
        const body = tour;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.managerToursUrl, body, options)
            .map((response: Response) => {
                if (response.status != 200) {
                    throw new Error('Error while loading all entities! code status: ' + response.status);
                } else {
                    return response.json();
                }
            })
    }

    createTour(tour: Tour) {
        const body = tour;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.tourUrl, body, options)
            .map((response: Response) => response.status === 201);
    }

    booking(tour: Tour) {
        const body = JSON.stringify({id: tour.id, booking: tour.booking, user: tour.user});
        const headers = new Headers({
            'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.bookingUrl, body, options)
            .map((response: Response) => response.status === 200);
    }

    unBooking(tour: Tour) {
        const body = tour;
        const headers = new Headers({
            'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.bookingUrl, body, options)
            .map((response: Response) => response.status === 200);
    }

    update(tour: Tour) {
        const body = tour;
        const headers = new Headers({
            'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.tourUrl, body, options)
            .map((response: Response) => response.status === 200);
    }
}