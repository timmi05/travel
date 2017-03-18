import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import 'rxjs/add/operator/toPromise';
import {Hotel} from "../model/hotel";

@Injectable()
export class HotelService{

private hotelUrl: string = 'travel/hotel';

    constructor(private http: Http) { }

    getHotels(): Promise<Hotel[]> {
        return this.http.get(this.hotelUrl)
            .toPromise()
            .then(responce => responce.json())
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }



}