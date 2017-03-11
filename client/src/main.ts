import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {AppModule} from './app/app.module';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

platformBrowserDynamic().bootstrapModule(AppModule);