import {Component, OnInit} from "@angular/core";
import {Tour} from "../model/tour";
import {TourService} from "../service/tour.service";
import {LoginService} from "../authorization/login.service";

@Component({
    selector: 'all-country',
    templateUrl: 'customer.component.html'
})
export class CustomerComponent implements OnInit {

    tours: Tour[] = [];

    loading: Boolean = false;

    // myForm: FormGroup;

    constructor(private tourService: TourService) {
    }

    ngOnInit(): void {
        this.tours = [];
        this.loadCustomer();
    }

    private loadCustomer() {
        this.tourService.loadUsersTours(LoginService.getCurrentUser())
            .subscribe(toursFromService => this.tours = toursFromService);
    }

    unBooking(tour: Tour): void {
        tour && this.tourService.unBooking(tour)
            .subscribe(() => this.ngOnInit(), error => this.errorUnBokingTout(error));
    }

    private errorUnBokingTout(error): void {
        console.log(error);
        this.loading = false;
        alert("Ошибка при отмене брони. Попробуйте отменить бронь еще раз или обратитесь к менеджеру!");
    }
}
