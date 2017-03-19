import {NgModule}      from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule}   from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AppRoutingModule}  from './app-routing.module';

import {AppComponent}   from './app.component';
import {CountryComponent}   from './countries/country.component';
import {CountryService} from './countries/country.service';
import {LocalCountryComponent} from "./countries/loc-country.component";
import {LoginComponent} from "./authorization/login.component";
import {HomeComponent} from "./home/home.component";
import {LoginService} from "./authorization/login.service";
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {AuthorizationGuard} from "./guard/authorization.guard";

@NgModule({
    imports: [BrowserModule, FormsModule, HttpModule, AppRoutingModule, CommonModule, ReactiveFormsModule, RouterModule],
    declarations: [AppComponent, CountryComponent, LocalCountryComponent, LoginComponent, HomeComponent],
    providers: [CountryService, LoginService, AuthorizationGuard],
    bootstrap: [AppComponent]
})
export class AppModule {
}