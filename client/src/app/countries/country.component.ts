import {Component, OnInit} from "@angular/core";
import {Country} from '../model/country';
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

    private getAllCountries() {
        this.countryService.getCountries()
            .subscribe(countriesFromService => this.data = countriesFromService);
    }
}
