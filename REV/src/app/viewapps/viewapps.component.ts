import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';
import { StorageService } from '../storage.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-viewapps',
  templateUrl: './viewapps.component.html',
  styleUrls: ['./viewapps.component.css']
})
export class ViewappsComponent implements OnInit {

  columns: string[];
  users: Observable<User[]>;

  constructor(
    private userService: UserService,
    private http: HttpClient,
    private storage: StorageService
   ) {}

  ngOnInit() {
    this.columns = ['id', 'firstName', 'lastName', 'email', 'city', 'state', 'client', 'batch_id', 'position', 'approved'];

    this.users = this.userService.getApps();
    console.log(this.users);
  }

}
