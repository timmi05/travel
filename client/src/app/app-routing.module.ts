import {NgModule} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import {CountryComponent} from "./countries/country.component";
import {LocalCountryComponent} from "./countries/loc-country.component";

const routes: Routes = [
    {path: 'all-country', component: CountryComponent},
    {path: 'local-country', component: LocalCountryComponent},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }