import {Town} from "./town";
export class Hotel {
    id: number;
    name: string;
    address: string;
    town: Town;

    constructor(name: string, address: string, town: Town) {
        this.name = name;
        this.address = address;
        this.town = town
    }
}