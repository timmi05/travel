import {Component, OnInit} from "@angular/core";
import {Access} from "../constants/access";
import {Country} from "../model/country";
import {Town} from "../model/town";
import {Hotel} from "../model/hotel";
import {Tour} from "../model/tour";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {CountryService} from "../service/country.service";
import {TownService} from "../service/town.service";
import {HotelService} from "../service/hotel.service";
import {TourService} from "../service/tour.service";
import {Router} from "@angular/router";
import {IMyOptions} from "mydatepicker";
import {LoginService} from "../authorization/login.service";


@Component({
    selector: 'home-component',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent  extends Access implements OnInit {

    countries: Country[] = [];
    allTowns: Town[] = [];
    towns: Town[] = [];
    allHotels: Hotel[] = [];
    tours: Tour[] = null;
    hotels: Hotel[] = [];
    selectedTown: Town;
    selectedCountry: Country;
    selectedHotel: Hotel;
    chooseDateForm: FormGroup;
    loading: Boolean = false;
    startDate: Date;
    chooseStartDate: Date;
    chooseEndDate: Date;

    constructor(private countryService: CountryService, private townService: TownService,
                private hotelService: HotelService, private tourService: TourService, private router: Router) {
        super();
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

    ngOnInit(): void {
        this.loadAllCountries();
        this.chooseDateForm = new FormGroup({
            chooseStartDate: new FormControl('', Validators.required),
            chooseEndDate: new FormControl('', Validators.required)
        });
    }

    private loadAllCountries() {
        this.countryService.getCountries()
            .subscribe(countriesFromService => this.countries = countriesFromService);
        this.loadAllTowns();
        this.selectedCountry = null;
    }

    onSubmitResetCountry() {
        this.selectedCountry = null;
        this.onChangeCountry();
    }

    private loadAllTowns() {
        this.townService.getTowns()
            .subscribe(townsFromService => this.allTowns = townsFromService);
        this.loadAllHotels();
        this.towns = [];
        this.selectedTown = null;
    }

    private loadAllHotels() {
        this.hotelService.getHotels()
            .subscribe(hotelsFromService => this.allHotels = hotelsFromService);
        this.loading = false;
        this.selectedHotel = null;
        this.hotels = [];
    }

    onChangeCountry() {
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

    onSubmitFindTour() {
        this.loading = true;
        this.tours = null;
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

    onBooking(tour: Tour): void {
        tour.user = LoginService.getCurrentUser();
        tour && this.tourService.bookingTour(tour)
            .subscribe(() => this.router.navigate(['mytours']), error => this.errorFindTou(error));
    }

    private errorFindTou(error): void {
        console.log(error);
        this.loading = false;
        alert("Ошибка при загрузке информации, попробуйте выбрать другие условия для поиска!");
    }
}