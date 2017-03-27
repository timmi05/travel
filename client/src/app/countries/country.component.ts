import {Component, OnInit} from "@angular/core";
import {Country} from '../model/country';
import {CountryService} from '../service/country.service';
import {TownService} from "../service/town.service";
import {Town} from "../model/town";
import {FormControl, FormGroup, Validators, FormBuilder} from "@angular/forms";
import {HotelService} from "../service/hotel.service";
import {Hotel} from "../model/hotel";
import {Tour} from "../model/tour";
import {TourService} from "../service/tour.service";
import {IMyOptions} from 'mydatepicker';

@Component({
    selector: 'all-country',
    templateUrl: './country.component.html',
    styleUrls: ['./country.component.css']
})
export class CountryComponent implements OnInit {

    countries: Country[] = [];
    allTowns: Town[] = [];
    towns: Town[] = [];
    allHotels: Hotel[] = [];
    tours: Tour[] = [];
    hotels: Hotel[] = [];
    selectedTown: Town;
    selectedCountry: Country;
    selectedHotel: Hotel;
    countryForm: FormGroup;
    townForm: FormGroup;
    hotelForm: FormGroup;
    tourForm: FormGroup;
    loading: Boolean = false;
    placeholder: String = 'Дата  заезда';

    constructor(private countryService: CountryService, private townService: TownService,
                private hotelService: HotelService, private tourService: TourService, private formBuilder: FormBuilder) {
        this.myForm = this.formBuilder.group({
            // Empty string means no initial value. Can be also specific date for
            // example: {date: {year: 2018, month: 10, day: 9}} which sets this date to initial
            // value.

            myDate: ['', Validators.required]
            // other controls are here...
        });
    }

    myDatePickerOptions: IMyOptions = {
        // other options...
        height: '20px',
        width: '150px',
        selectionTxtFontSize: '12px',
        dateFormat: 'dd.mm.yyyy',
    };

    private myForm: FormGroup;

    setDate(): void {
        // Set today date using the setValue function
        let date = new Date();
        this.myForm.setValue({myDate: {
            date: {
                year: date.getFullYear(),
                month: date.getMonth() + 1,
                day: date.getDate()}
        }});
    }

    ngOnInit(): void {
        this.loadAllCountries();
        this.tourForm = new FormGroup({
            price: new FormControl('', Validators.required),
            nights: new FormControl('', Validators.required),
            persons: new FormControl('', Validators.required),
            startDate: new FormControl('', Validators.required),
        });
    }

    private loadAllCountries() {
        this.countryService.getCountries()
            .subscribe(countriesFromService => this.countries = countriesFromService);
        this.loadAllTowns();
        this.selectedCountry = null;
        this.countryForm = new FormGroup({
            countryName: new FormControl('', Validators.required),
        });
    }

    private loadAllTowns() {
        this.townService.getTowns()
            .subscribe(townsFromService => this.allTowns = townsFromService);
        this.loadAllHotels();
        this.towns = [];
        this.selectedTown = null;
        this.townForm = new FormGroup({
            townName: new FormControl('', Validators.required),
        });
    }

    private loadAllHotels() {
        this.hotelService.getHotels()
            .subscribe(hotelsFromService => this.allHotels = hotelsFromService);
        this.loading = false;
        this.selectedHotel = null;
        this.hotels = [];
        this.hotelForm = new FormGroup({
            hotelName: new FormControl('', Validators.required),
            address: new FormControl('', Validators.required),
        });
    }

    onChangeCountry(event: Event) {
        console.log("Change selected country:" + this.selectedCountry.name + ". Time " + event.timeStamp)
        this.towns = [];
        this.hotels = [];
        this.selectedTown = null;
        this.selectedHotel = null;
        for (let town of this.allTowns) {
            if (town.country.id === this.selectedCountry.id) {
                this.towns.push(town);
            }
        }
    }

    onChangeTown() {
        this.hotels = [];
        this.selectedHotel = null;
        for (let hotel of this.allHotels) {
            if (hotel.town.id === this.selectedTown.id) {
                this.hotels.push(hotel);
            }
        }
    }

    onSubmitCountry() {
        this.loading = true;
        const country: Country = new Country(this.countryForm.value.countryName);
        this.countryService.newCountry(country)
            .subscribe(() => this.ngOnInit(),
                error => this.errorCountryMsg(error));
    }

    onSubmitTown() {
        this.loading = true;
        const town: Town = new Town(this.townForm.value.townName, this.selectedCountry);
        this.townService.newTown(town)
            .subscribe(() => this.loadAllTowns(),
                error => this.errorTownMsg(error));
    }

    onSubmitHotel() {
        this.loading = true;
        const hotel: Hotel = new Hotel(this.hotelForm.value.hotelName, this.hotelForm.value.address, this.selectedTown);
        this.hotelService.newHotel(hotel)
            .subscribe(() => this.loadAllHotels(),
                error => this.errorHotelMsg(error),() =>  this.onChangeTown());
    }

    onSubmitTour() {
        this.loading = true;
        const tour: Tour = new Tour(this.selectedHotel, this.selectedTown, this.selectedCountry);
        this.tourService.newTour(tour)
            .subscribe(() => this.Successfull(),
                error => this.errorHotelMsg(error));
        this.tourForm = new FormGroup({
            price: new FormControl('', Validators.required),
            nights: new FormControl('', Validators.required),
            persons: new FormControl('', Validators.required),
            startDate: new FormControl('', Validators.required),
        });
    }

    onSubmitFindTour() {
        this.loading = true;
        const tour: Tour = new Tour(this.selectedHotel, this.selectedTown, this.selectedCountry);
        this.tourService.findTours(tour)
            .subscribe(toursFromService => this.tours = toursFromService);
    }

    private errorCountryMsg(error): void {
        console.log(error);
        this.loading = false;
        alert("Error while creating new country!");
    }

    private errorTownMsg(error): void {
        console.log(error);
        this.loading = false;
        alert("Error while creating new town!");
    }

    private Successfull(): void {
        this.loading = false;
        alert("Тур успешно добавлен");
    }

    private errorHotelMsg(error): void {
        console.log(error);
        this.loading = false;
        alert("Error while creating new hotel!");
    }
}
