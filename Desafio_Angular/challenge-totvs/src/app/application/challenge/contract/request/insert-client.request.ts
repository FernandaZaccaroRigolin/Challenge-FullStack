import { Client } from "src/app/domain/challenge/model/client";

export class InsertClientRequest{
  name!: string;
  address!: string;
  district!: string;
  phones: {
    number: string;
  }[] = [];

  constructor(dados: Partial<InsertClientRequest> = {}) {
    Object.assign(this, dados);
  }

  static converter(client: Partial<Client>): InsertClientRequest {
    return new InsertClientRequest({
      name: client.name,
      address: client.address,
      district: client.district,
      phones: client.phones
    });
  }
}