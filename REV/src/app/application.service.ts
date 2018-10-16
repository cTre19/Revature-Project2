import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { User } from './user';
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

export class ApplicationService {

  url = 'http://localhost:8080/REVjava/application';

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }

  /** POST: send credentials to server */
  postUser(user: User): Observable<User> {
    return this.http.post<User>(this.url, user, httpOptions);
  }
}
