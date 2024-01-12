import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from 'src/app/domain/challenge/model/client';
import { ClientService } from 'src/app/infrastructure/challenge/service/client.service';


@Injectable()
export class ClientFacadeService {
	constructor(private service: ClientService) {}

	public insertClient(client: Partial<Client> = {}): Observable<Client> { 
		return this.service.insertClient(client);
	}

	public getAllClient(): Observable<Client[]> {
		return this.service.getAllClient();
	}

	public getClientName(name: string): Observable<Client[]> {
		return this.service.getClientName(name);
	}	

	public getClientPhone(phone: string): Observable<Client[]> {
		return this.service.getClientPhone(phone);
	}	


	public insertClientJSON(client: Client): Observable<Client> { 
		return this.service.insertClientJSON(client);
	}

	// this.service.insertClient(client).subscribe(
	// 	(response: Client) => {
	// 		return this.service.insertClientJSON(response).subscribe();
	// 	},
	// 	(error: HttpErrorResponse) => {
	// 		return error;
	// 	}

	// );    


}