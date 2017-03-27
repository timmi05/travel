import {Country} from "./country";
export class Town {
    id: number;
    name: string;
    country: Country;

    constructor(name: string, country: Country) {
        this.name = name;
        this.country = country
    }
}