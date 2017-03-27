import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers, Response} from "@angular/http";
import {Observable} from "rxjs";
import {Hotel} from "../model/hotel";
import {LoginService} from "../authorization/login.service";

@Injectable()
export class HotelService{

private hotelUrl: string = 'travel/hotel';

    constructor(private http: Http) { }

    getHotels() {
        return this.http.get(this.hotelUrl)
            .map((response: Response) => response.json())
            .catch(HotelService.handleError);
    }

    newHotel(hotel: Hotel){
        const body = hotel;
        const headers = new Headers({'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token});
        const options = new RequestOptions({headers: headers});
        return this.http.post(this.hotelUrl, body, options).map((response: Response) => response.status === 201);
    }

    updateHotel(hotel: Hotel){
        const body = hotel;
        const headers = new Headers({'Content-Type': 'application/json', 'x-auth-token': LoginService.getCurrentUser().token});
        const options = new RequestOptions({headers: headers});
        return this.http.put(this.hotelUrl, body, options).map((response: Response) => response.status === 200);
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