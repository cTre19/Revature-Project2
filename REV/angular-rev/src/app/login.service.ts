import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Credentials } from './credentials';
import { catchError, map, tap } from 'rxjs/operators';
import { MessageService } from './message.service';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url = 'http://localhost:8080/REVjava/login';

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }

  /** POST: send credentials to server */
  postLogin(credentials: Credentials): Observable<Credentials> {
    return this.http.post<Credentials>(this.url, credentials, httpOptions);
  }


}
