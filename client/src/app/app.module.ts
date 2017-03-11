import {NgModule}      from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule}   from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AppRoutingModule}  from './app-routing.module';

import {AppComponent}   from './app.component';
import {CountryComponent}   from './countries/country.component';
import {CountryService} from './countries/country.service';
import {LocalCountryComponent} from "./countries/loc-country.component";

@NgModule({
    imports: [BrowserModule, FormsModule, HttpModule, AppRoutingModule],
    declarations: [AppComponent, CountryComponent, LocalCountryComponent],
    providers: [CountryService],
    bootstrap: [AppComponent]
})
export class AppModule {
}