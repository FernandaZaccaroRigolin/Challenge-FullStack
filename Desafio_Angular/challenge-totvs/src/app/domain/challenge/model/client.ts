import { Phone } from "./phone";

export class Client {
  id?: string;
  name: string;
  address: string;
  district: string;
  phones: Phone[] = [];

  constructor() {
    this.name = '';
    this.address = '';
    this.district = '';
  }
}