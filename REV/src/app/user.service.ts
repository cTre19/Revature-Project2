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
  url2 = 'http://localhost:8080/REVjava/emps';
  url3 = 'http://localhost:8080/REVjava/group';


  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }

  /** POST: send credentials to server */
  getApps(): Observable<User[]> {
    return this.http.get<User[]>(this.url, httpOptions);
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.url2, httpOptions);
  }

  getGroup(user: User): Observable<User[]> {
    return this.http.post<User[]>(this.url3, user, httpOptions);
  }

  update(user: User): Observable<User> {
    console.log('inside put');
    console.log('user email: ' + user.email);
    return this.http.put<User>(this.url, user, httpOptions);
  }

  delete(user: User): Observable<User> {
    console.log('inside delete');
    console.log('user email: ' + user.email);
    return this.http.delete<User>(this.url + '/' + user.email, httpOptions);
  }
}
