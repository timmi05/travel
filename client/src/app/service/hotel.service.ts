import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers, Response} from "@angular/http";
import {Hotel} from "../model/hotel";
import {LoginService} from "../authorization/login.service";

@Injectable()
export class HotelService {

    private hotelUrl: string = 'travel/hotel';

    constructor(private http: Http) {
    }

    loadHotels() {
        return this.http.get(this.hotelUrl)
            .map((response: Response) => {
                if(response.status != 200) {
                    throw new Error('Error while loading all entities! code status: ' + response.status);
                } else {
                    return response.json();
                }
            })
    }

    add(hotel: Hotel) {
        const body = hotel;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.hotelUrl, body, options).map((response: Response) => response.status === 201);
    }

    update(hotel: Hotel) {
        const body = hotel;
        const headers = new Headers({
            'Content-Type': 'application/json',
            'x-auth-token': LoginService.getCurrentUser().token
        });
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.hotelUrl, body, options).map((response: Response) => response.status === 200);
    }
}