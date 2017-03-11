import {Component} from "@angular/core";

@Component({
    selector: 'my-app',
    templateUrl: './app.component.html',
    styleUrls: ['appStyle.css'],
})
export class AppComponent {
    country: string = 'Some country';
}