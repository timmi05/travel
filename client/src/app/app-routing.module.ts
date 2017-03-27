import {NgModule} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import {CountryComponent} from "./countries/country.component";
import {HomeComponent} from "./home/home.component";
import {AuthorizationGuard} from "./guard/authorization.guard";
import {LoginComponent} from "./authorization/login.component";

const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    {path: 'login', component: LoginComponent},
    {path: 'all-country', component: CountryComponent, canActivate: [AuthorizationGuard], data: { roles: ['ROLE_ADMIN']}},
];

@NgModule( {
    imports: [RouterModule.forRoot( routes )],
    exports: [RouterModule]
})
export class AppRoutingModule { }