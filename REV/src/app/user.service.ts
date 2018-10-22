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
export class UserService {

  url = 'http://localhost:8080/REVjava/user';

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }

  /** POST: send credentials to server */
  getApps(): Observable<User[]> {
    return this.http.get<User[]>(this.url, httpOptions);
  }
}
