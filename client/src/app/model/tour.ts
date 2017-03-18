import {Town} from "./town";
import {Hotel} from "./hotel";
import {Country} from "./country";
import {User} from "./user";
export class Tour {
    id: number;
    name: string;
    hotel: Hotel;
    town: Town;
    country: Country;
    user: User;
    price: number;
    nights: number;
    persons: number;
    startDate: Date;
    endDate: Date;
    hot: boolean;
    used: boolean;
    booking: Date;
    paid: boolean;
    archive: boolean;
}