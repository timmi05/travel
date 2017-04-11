import {NgModule} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import {TourComponent} from "./countries/tour.component";
import {HomeComponent} from "./home/home.component";
import {AuthorizationGuard} from "./guard/authorization.guard";
import {LoginComponent} from "./authorization/login.component";
import {RegistrationComponent} from "./registration/registration.component";
import {CustomerComponent} from "./customer/customer.component";

const routes: Routes = [
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: 'home', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'registration', component: RegistrationComponent},
    {
        path: 'mytours',
        component: CustomerComponent,
        canActivate: [AuthorizationGuard],
        data: {roles: ['ROLE_USER', 'ROLE_MANAGER', 'ROLE_ADMIN']}
    },
    {
        path: 'tourswork',
        component: TourComponent,
        canActivate: [AuthorizationGuard],
        data: {roles: ['ROLE_ADMIN', 'ROLE_MANAGER']}
    },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}