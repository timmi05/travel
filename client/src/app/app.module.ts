import {NgModule}      from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule}   from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AppRoutingModule}  from './app-routing.module';
import {AppComponent}   from './app.component';
import {CountryComponent}   from './countries/country.component';
import {CountryService} from './service/country.service';
import {LoginComponent} from "./authorization/login.component";
import {HomeComponent} from "./home/home.component";
import {LoginService} from "./authorization/login.service";
import {CommonModule, LocationStrategy, HashLocationStrategy} from "@angular/common";
import {RouterModule} from "@angular/router";
import {AuthorizationGuard} from "./guard/authorization.guard";
import {TownService} from "./service/town.service";
import {HotelService} from "./service/hotel.service";
import {TourService} from "./service/tour.service";
import {UserService} from "./service/user.service";
import {MyDatePickerModule} from 'mydatepicker';
import {RegistrationComponent} from "./registration/registration.component";
import {CustomerComponent} from "./customer/customer.component";

@NgModule({
    imports: [MyDatePickerModule, BrowserModule, FormsModule,
        HttpModule, AppRoutingModule, CommonModule,
        ReactiveFormsModule, RouterModule],
    declarations: [AppComponent, CountryComponent, LoginComponent,
        HomeComponent, RegistrationComponent, CustomerComponent],
    providers: [{
        provide: LocationStrategy,
        useClass: HashLocationStrategy
    }, CountryService, LoginService, AuthorizationGuard,
        TownService, HotelService, TourService,
        UserService],
    bootstrap: [AppComponent]
})
export class AppModule {
}