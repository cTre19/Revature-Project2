import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';
import { LOCAL_STORAGE } from 'angular-webstorage-service';
import { StorageService } from '../storage.service';
import { Observable } from 'rxjs';
import { UserService } from '../user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  columns = ['firstName', 'lastName', 'email', 'client', 'batch_id', 'position'];
  users: Observable<User[]>;

  name = '';
  fname = '';
  lname = '';
  email = '';
  city = '';
  state = '';
  batch_id = 0;
  client = '';
  position = '';
  user = this.storage.getFromLocal('1');

  constructor(
    private storage: StorageService,
    private userService: UserService,
    private http: HttpClient) { }

  ngOnInit() {
    if (this.storage.getFromLocal('1') == null) {
      location.replace('/login');
    } else {
      this.name = this.user.firstName + ' ' + this.user.lastName;
      this.email = this.user.email;
      this.city = this.user.city;
      this.state = this.user.state;
      this.batch_id = this.user.batch_id;
      this.client = this.user.client;
      this.position = this.user.position;

      this.users = this.userService.getGroup(this.user);

    }
  }

}
