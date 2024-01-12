import { Injectable } from '@angular/core';
import { Observable, from, of, throwError } from 'rxjs';
import { Constants } from 'src/app/application/constants';
import { map, catchError } from 'rxjs/operators';
import { HttpClient, HttpErrorResponse, HttpHeaders  } from '@angular/common/http';
import { Client } from 'src/app/domain/challenge/model/client';
import { InsertClientRequest } from 'src/app/application/challenge/contract/request/insert-client.request';
import { InsertClientResponse } from 'src/app/application/challenge/contract/response/insert-client.response';

@Injectable({ providedIn: 'root' })
export class ClientService {

  private jsonServerUrl = `${Constants.endpoint.challengeUrl.baseJSON}/${Constants.endpoint.challengeUrl.client}`;
  private javaBackendUrl = `${Constants.endpoint.challengeUrl.baseBackendUrl}/${Constants.endpoint.challengeUrl.client}`;
  
	constructor(private http: HttpClient) {}

  insertClient(client: Partial<Client>) : Observable<Client> {
      return this.http.post<InsertClientResponse>(this.javaBackendUrl, InsertClientRequest.converter(client))
      .pipe(
        map(InsertClientResponse.converter)
      );
  }

  public getAllClient(): Observable<Client[]> {
    return this.http.get<Client[]>(`${this.jsonServerUrl}`);
  } 

  public getClientName(name: string): Observable<Client[]> {
    const url = `${this.jsonServerUrl}?name=${encodeURIComponent(name)}`;
    return this.http.get<Client[]>(url);
  }

  public getClientPhone(phone: string): Observable<Client[]> {
    const url = `${this.jsonServerUrl}?phones.number=${encodeURIComponent(phone)}`;
    return this.http.get<Client[]>(url);
  }  

  insertClientJSON(client: Client) : Observable<Client> {  
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<Client>(this.jsonServerUrl, client, { headers })
    .pipe(
      catchError((error: HttpErrorResponse) => {
        console.error('Erro:', error);
        return throwError(error);
      })
    );
 
  }
}