import {Component, OnInit} from "@angular/core";
import {Country} from '../model/country';
import {CountryService} from '../service/country.service';
import {TownService} from "../service/town.service";
import {Town} from "../model/town";
import {FormControl, FormGroup, Validators} from "@angular/forms";
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
    chooseDateForm: FormGroup;
    loading: Boolean = false;
    placeholder: String = 'Дата  заезда';
    startDate: Date;
    chooseStartDate: Date;
    chooseEndDate: Date;

    // myForm: FormGroup;

    constructor(private countryService: CountryService, private townService: TownService,
                private hotelService: HotelService, private tourService: TourService) {
        // , private formBuilder: FormBuilder) {

    }

    myDatePickerOptions: IMyOptions = {
        // other options...
        height: '20px',
        width: '150px',
        selectionTxtFontSize: '12px',
        dateFormat: 'dd.mm.yyyy',
        todayBtnTxt: 'Сегодня',
        dayLabels: {su: 'Вс', mo: 'Пн', tu: 'Вт', we: 'Ср', th: 'Чт', fr: 'Пт', sa: 'Сб'},
        monthLabels: {
            1: 'Янв',
            2: 'Фев',
            3: 'Март',
            4: 'Апр',
            5: 'Май',
            6: 'Ин',
            7: 'Ил',
            8: 'Авг',
            9: 'Сен',
            10: 'Окт',
            11: 'Нояб',
            12: 'Дек'
        },
    };

    // setDate(): void {
    //     // Set today date using the setValue function
    //     let date = new Date();
    //     this.myForm.setValue({myDate: {
    //         date: {
    //             year: date.getFullYear(),
    //             month: date.getMonth() + 1,
    //             day: date.getDate()}
    //     }});
    // }

    ngOnInit(): void {
        this.loadAllCountries();
        this.removeTourForm();

        this.chooseDateForm = new FormGroup({
            chooseStartDate: new FormControl('', Validators.required),
            chooseEndDate: new FormControl('', Validators.required)
        });

        // this.myForm = this.formBuilder.group({
        //     // Empty string means no initial value. Can be also specific date for
        //     // example: {date: {year: 2018, month: 10, day: 9}} which sets this date to initial
        //     // value.
        //
        //     startDate: ['', Validators.required]
        //     // other controls are here...
        // });
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
                error => this.errorTownMsg(error), () => this.onChangeCountry(event));
    }

    onSubmitHotel() {
        this.loading = true;
        const hotel: Hotel = new Hotel(this.hotelForm.value.hotelName, this.hotelForm.value.address, this.selectedTown);
        this.hotelService.newHotel(hotel)
            .subscribe(() => this.loadAllHotels(),
                error => this.errorHotelMsg(error), () => this.onChangeTown());
    }

    onSubmitTour() {
        this.loading = true;
        const tour: Tour = new Tour();
        tour.hotel = this.selectedHotel;
        tour.town = this.selectedTown;
        tour.country = this.selectedCountry;
        tour.startDate = this.tourForm.value.startDate.jsdate;
        tour.price = this.tourForm.value.price;
        tour.nights = this.tourForm.value.nights;
        tour.persons = this.tourForm.value.persons;
        this.tourService.newTour(tour)
            .subscribe(() => this.successfull('Тур'),
                error => this.errorHotelMsg(error), () => this.removeTourForm());

    }

    private removeTourForm() {
        this.loading = false;
        this.tourForm = new FormGroup({
            price: new FormControl('', Validators.required),
            nights: new FormControl('', Validators.required),
            persons: new FormControl('', Validators.required),
            startDate: new FormControl('', Validators.required),
        });
    }

    onSubmitFindTour() {
        this.loading = true;
        this.tours = [];
        const tour: Tour = new Tour();
        tour.hotel = this.selectedHotel;
        tour.town = this.selectedTown;
        tour.country = this.selectedCountry;
        tour.startDate = this.chooseDateForm.value.chooseStartDate.jsdate;
        tour.endDate = this.chooseDateForm.value.chooseEndDate.jsdate;
        this.tourService.findTours(tour)
            .subscribe(toursFromService => this.tours = toursFromService, error => this.errorFindTou(error),
                () => this.afterFindTour());
    }

    private afterFindTour() {
        this.loading = false;
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

    private successfull(entity: String): void {
        this.loading = false;
        var a: String = '';
        if (entity === 'Страна') {
            a = 'а'
        }
        alert(entity + " успешно добавлен " + a);
    }

    private errorHotelMsg(error): void {
        console.log(error);
        this.loading = false;
        alert("Error while creating new hotel!");
    }

    private errorFindTou(error): void {
        console.log(error);
        this.loading = false;
        alert("Ошибка при загрузке информации, попробуйте выбрать другие условия для поиска!");
    }
}
