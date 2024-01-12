import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Client } from "src/app/domain/challenge/model/client";

export class InsertClientResponse{
  id!: string;
  name!: string;
  address!: string;
  district!: string;
  phones: {
    number: string;
  }[] = [];

  constructor(dados: Partial<InsertClientResponse> = {}) {
    Object.assign(this, dados);
  }

  static converter(clientResponse: InsertClientResponse): Client {
    const client: Client = new Client();
    client.id = clientResponse.id;
    client.name = clientResponse.name;
    client.address = clientResponse.address;
    client.district = clientResponse.district;
    client.phones = clientResponse.phones;
    return client;
  }
}