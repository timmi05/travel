import {Component, OnInit} from "@angular/core";
import {Country} from './country';
import {CountryService} from './country.service';

@Component({
    selector: 'all-country',
    templateUrl: './country.component.html'
})
export class CountryComponent implements OnInit{

    data: Country[];

    constructor(private countryService: CountryService) {
    }

    ngOnInit(): void {
        this.getAllCountries();
    }

    getAllCountries(): void {
        this.countryService.getCountries()
            .then(countriesFromService => this.data = countriesFromService);
    }

}
