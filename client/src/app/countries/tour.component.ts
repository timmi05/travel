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
import {User} from "../model/user";
import {environment} from "../constants/environment";

@Component({
    selector: 'tourswork',
    templateUrl: 'tour.component.html',
    styleUrls: ['tour.component.css']
})
export class TourComponent implements OnInit {

    countries: Country[] = [];
    allTowns: Town[] = [];
    towns: Town[] = [];
    allHotels: Hotel[] = [];
    tours: Tour[] = null;
    hotels: Hotel[] = [];
    tour: Tour;
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
    addCountry: Boolean = false;
    editCountry: Boolean = false;
    addTown: Boolean = false;
    editTown: Boolean = false;
    addHotel: Boolean = false;
    editHotel: Boolean = false;
    addTour: Boolean = false;
    editTour: Boolean = false;
    customer: User;
    customerOpen: boolean = false;
    errorEntityAdd: String;
    errorTourEdit: String;
    errorFindTourMas: String;


    constructor(private countryService: CountryService, private townService: TownService,
                private hotelService: HotelService, private tourService: TourService) {
    }

    myDatePickerOptions: IMyOptions = {
        // other options...
        height: '30px',
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

    ngOnInit(): void {
        this.loadAllCountries();
        this.removeTourForm();
        this.chooseDateForm = new FormGroup({
            chooseStartDate: new FormControl('', Validators.required),
            chooseEndDate: new FormControl('', Validators.required)
        });
    }

    private loadAllCountries() {
        this.countryService.loadCountries()
            .subscribe((countriesFromService) => this.countries = countriesFromService);
        this.loadAllTowns();
        this.selectedCountry = null;
        this.countryForm = new FormGroup({
            countryName: new FormControl('', Validators.required),
        });
        this.towns = [];
    }

    onSubmitAddCountry() {
        this.addCountry = true;
        this.editCountry = false;
        this.countryForm = new FormGroup({
            countryName: new FormControl('', Validators.required),
        });
    }

    onSubmitAddCountryCancel() {
        this.emptyError();
        this.addCountry = false;
        this.editCountry = false;
        this.countryForm = new FormGroup({
            countryName: new FormControl('', Validators.required),
        });
    }

    onSubmitEditCountry() {
        this.addCountry = true;
        this.editCountry = true;
        this.countryForm.setValue({
            countryName: this.selectedCountry.name
        })
    }

    onSubmitResetCountry() {
        this.selectedCountry = null;
        this.onChangeCountry();
        this.addCountry = false;
        this.addTown = false;
        this.addHotel = false;
        this.addTour = false;
    }


    handlerTown = function (townsFromService) {
        this.allTowns = townsFromService;
        this.onChangeCountry();
    };

    private loadAllTowns() {
        this.townService.loadTowns()
            .subscribe((townsFromService) => this.handlerTown(townsFromService));
        this.loadAllHotels();
        this.townForm = new FormGroup({
            townName: new FormControl('', Validators.required),
        });
    }

    onSubmitAddTown() {
        this.addTown = true;
        this.editTown = false;
        this.townForm = new FormGroup({
            townName: new FormControl('', Validators.required),
        });
    }

    onSubmitAddTownCancel() {
        this.emptyError();
        this.addTown = false;
        this.editTown = false;
        this.townForm = new FormGroup({
            townName: new FormControl('', Validators.required),
        });
    }

    onSubmitEditTown() {
        this.addTown = true;
        this.editTown = true;
        this.townForm.setValue({
            townName: this.selectedTown.name
        })
    }

    handlerHotel = function (hotelsFromService) {
        this.allHotels = hotelsFromService;
        this.onChangeTown();

    };

    private loadAllHotels() {
        this.hotelService.loadHotels()
            .subscribe((hotelsFromService) => this.handlerHotel(hotelsFromService));
        this.loading = false;
        this.hotelForm = new FormGroup({
            hotelName: new FormControl('', Validators.required),
            address: new FormControl('', Validators.required),
        });
        this.emptyError();
    }

    onSubmitAddHotel() {
        this.addHotel = true;
        this.editHotel = false;
        this.hotelForm = new FormGroup({
            hotelName: new FormControl('', Validators.required),
            address: new FormControl('', Validators.required),
        });
    }

    onSubmitAddHotelCancel() {
        this.emptyError();
        this.addHotel = false;
        this.editHotel = false;
        this.hotelForm = new FormGroup({
            hotelName: new FormControl('', Validators.required),
            address: new FormControl('', Validators.required),
        });
    }

    onSubmitEditHotel() {
        this.addHotel = true;
        this.editHotel = true;
        this.hotelForm.setValue({
            hotelName: this.selectedHotel.name,
            address: this.selectedHotel.address
        })
    }

    onChangeCountry() {
        this.towns = [];
        this.hotels = [];
        this.selectedTown = null;
        this.selectedHotel = null;
        this.onSubmitAddCountryCancel();
        this.onSubmitAddTownCancel();
        this.onSubmitAddHotelCancel();
        if (this.selectedCountry) {
            for (let town of this.allTowns) {
                if (town.country.id === this.selectedCountry.id) {
                    this.towns.push(town);
                }
            }
        }
    }

    onChangeTown() {
        this.hotels = [];
        this.selectedHotel = null;
        this.onSubmitAddHotelCancel();
        if (this.selectedTown) {
            for (let hotel of this.allHotels) {
                if (hotel.town.id === this.selectedTown.id) {
                    this.hotels.push(hotel);
                }
            }
        }
    }

    onSubmitCountry() {
        this.loading = true;
        let country: Country = null;
        if (this.editCountry) {
            country = this.selectedCountry;
            country.name = this.countryForm.value.countryName;
            this.countryService.update(country)
                .subscribe(
                    () => {
                        this.ngOnInit();
                        this.addCountry = false;
                        this.editCountry = false
                    },
                    error => this.errorCountryMsg(error));

        } else {
            country = new Country(this.countryForm.value.countryName);
            this.countryService.add(country)
                .subscribe(
                    () => {
                        this.ngOnInit();
                        this.addCountry = false;
                    },
                    error => this.errorCountryMsg(error));
        }
    }

    onSubmitTown() {
        this.loading = true;
        let town: Town = null;
        if (this.editTown) {
            town = this.selectedTown;
            town.name = this.townForm.value.townName;
            this.townService.update(town)
                .subscribe(
                    () => {
                        this.loadAllTowns();
                        this.addTown = false;
                        this.editTown = false;
                    },
                    error => this.errorCountryMsg(error));

        } else {
            town = new Town(this.townForm.value.townName, this.selectedCountry);
            this.townService.add(town)
                .subscribe(
                    () => {
                        this.loadAllTowns();
                        this.addTown = false;
                    },
                    error => this.errorCountryMsg(error));
        }
    }

    onSubmitHotel() {
        this.loading = true;
        let hotel: Hotel = null;
        if (this.editHotel) {
            hotel = this.selectedHotel;
            hotel.name = this.hotelForm.value.hotelName;
            hotel.address = this.hotelForm.value.address;
            this.hotelService.update(hotel)
                .subscribe(() => {
                        this.loadAllHotels();
                        this.addHotel = false;
                        this.editHotel = false;
                    },
                    error => this.errorCountryMsg(error));
        } else {
            hotel = new Hotel(this.hotelForm.value.hotelName, this.hotelForm.value.address, this.selectedTown);
            this.hotelService.add(hotel)
                .subscribe(() => {
                        this.loadAllHotels();
                        this.addHotel = false;
                    },
                    error => this.errorCountryMsg(error));
        }
    }

    onSubmitAddTour() {
        this.addTour = true;
        this.editTour = false;
        this.tourForm = new FormGroup({
            price: new FormControl('', [Validators.required, Validators.pattern(environment.DOUBLE)]),
            nights: new FormControl('', [Validators.required, Validators.pattern(environment.DOUBLE)]),
            persons: new FormControl('', [Validators.required, Validators.pattern(environment.DOUBLE)]),
            startDate: new FormControl('', Validators.required),
        });
    }

    onSubmitAddTourCancel() {
        this.addTour = false;
        this.editTour = false;
        this.removeTourForm();
    }

    onSubmitEditTour(tour: Tour) {
        this.tour = tour;
        this.addTour = true;
        this.editTour = true;
        let date = new Date(this.tour.startDate);
        this.tourForm.setValue({
            price: this.tour.price,
            nights: this.tour.nights,
            persons: this.tour.persons,
            startDate: {
                date: {
                    year: date.getFullYear().valueOf(),
                    month: date.getMonth() + 1,
                    day: date.getDate()
                }
            }
        })
    }

    onSubmitTour() {
        this.loading = true;
        let tour: Tour = null;
        if (this.editTour) {
            tour = this.tour;
            if (this.tourForm.value.startDate.jsdate) {
                tour.startDate = this.tourForm.value.startDate.jsdate;
            }
            tour.price = this.tourForm.value.price;
            tour.nights = this.tourForm.value.nights;
            tour.persons = this.tourForm.value.persons;
            this.tourService.update(tour)
                .subscribe(() => {
                        this.onSubmitFindTour();
                        this.onSubmitAddTourCancel();
                    },
                    error => this.errorCountryMsg(error),);

        } else {
            tour = new Tour();
            tour.hotel = this.selectedHotel;
            tour.town = this.selectedTown;
            tour.country = this.selectedCountry;
            tour.startDate = this.tourForm.value.startDate.jsdate;
            tour.price = this.tourForm.value.price;
            tour.nights = this.tourForm.value.nights;
            tour.persons = this.tourForm.value.persons;
            this.tourService.createTour(tour)
                .subscribe(() => {
                        this.onSubmitFindTour();
                        this.onSubmitAddTourCancel();
                    },
                    error => this.errorCountryMsg(error),);
        }
    }

    unBooking(tour: Tour): void {
        this.emptyError();
        tour && this.tourService.unBooking(tour)
            .subscribe(() => this.onSubmitFindTour(),
                error => this.errorTourlMsg(error));
    }

    onPaid(tour: Tour): void {
        this.emptyError();
        tour.paid = true;
        tour && this.tourService.update(tour)
            .subscribe(() => this.onSubmitFindTour(),
                error => this.errorTourlMsg(error));
    }

    onArchive(tour: Tour): void {
        this.emptyError();
        tour.archive = true;
        tour && this.tourService.update(tour)
            .subscribe(() => this.onSubmitFindTour(),
                error => this.errorTourlMsg(error));
    }

    private removeTourForm() {
        this.loading = false;
        this.tourForm = new FormGroup({
            price: new FormControl('', [Validators.required, Validators.pattern(environment.DOUBLE)]),
            nights: new FormControl('', [Validators.required, Validators.pattern(environment.DOUBLE)]),
            persons: new FormControl('', [Validators.required, Validators.pattern(environment.DOUBLE)]),
            startDate: new FormControl('', Validators.required),
        });
    }

    onCustomer(tour: Tour) {
        this.emptyError();
        this.customer = tour.user;
        this.customerOpen = true;
    }

    onCustomerClose() {
        this.customer = null;
        this.customerOpen = false;
    }

    handlerFindTour = function (toursFromService) {
        this.tours = toursFromService;
        this.loading = false;
    };

    onSubmitFindTour() {
        this.emptyError();
        this.loading = true;
        this.tours = null;
        const tour: Tour = new Tour();
        tour.hotel = this.selectedHotel;
        tour.town = this.selectedTown;
        tour.country = this.selectedCountry;
        tour.startDate = this.chooseDateForm.value.chooseStartDate.jsdate;
        tour.endDate = this.chooseDateForm.value.chooseEndDate.jsdate;
        this.tourService.findToursForManager(tour)
            .subscribe((toursFromService) => this.handlerFindTour(toursFromService), error => this.errorFindTour(error));
    }

    private errorCountryMsg(error): void {
        console.log(error);
        this.loading = false;
        this.errorEntityAdd = 'Ошибка при внесении данных. Возможно эти данные уже внесены';
    }

    private errorTourlMsg(error): void {
        console.log(error);
        this.loading = false;
        this.errorTourEdit = 'Ошибка при отправке данных!';
    }

    private errorFindTour(error): void {
        console.log(error);
        this.loading = false;
        this.errorFindTourMas = 'Ошибка при загрузке информации, попробуйте выбрать другие условия для поиска';
    }

    private emptyError() {
        this.errorEntityAdd = '';
        this.errorTourEdit = '';
        this.errorFindTourMas = '';
    }
}
