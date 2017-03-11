import {Component} from "@angular/core";
import {Http} from "@angular/http";


@Component({
    selector: 'local-country',
    templateUrl: './loc-country.component.html'
})
export class LocalCountryComponent {
    data: Object;
    constructor(private http: Http) {
        this.http.get('travel/country').map(res => res.json()).subscribe(data => this.data = data, err => console.log(err));
    }
}
