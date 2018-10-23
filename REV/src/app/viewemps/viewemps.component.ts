import { Component, OnInit } from '@angular/core';
import { Pipe, PipeTransform } from '@angular/core';
import { User } from '../user';
import { Observable } from 'rxjs';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';
import { StorageService } from '../storage.service';

@Component({
  selector: 'app-viewemps',
  templateUrl: './viewemps.component.html',
  styleUrls: ['./viewemps.component.css']
})
export class ViewempsComponent implements OnInit {

  columns = ['firstName', 'lastName', 'email', 'city', 'state', 'client', 'batch_id', 'position'];
  users: Observable<User[]>;
  email: '';

  constructor(
    private userService: UserService,
    private http: HttpClient,
    private storage: StorageService) { }

  ngOnInit() {

    this.users = this.userService.getUsers();
  }

}

@Pipe({
 name: 'filter'
})

export class FilterPipe implements PipeTransform {
   transform(users: User[], searchText: string): any[] {
     if (!users) {return []; }
     if (!searchText) {return users; }
 searchText = searchText.toLowerCase();
 return users.filter( it => {
       return it.email.toLowerCase().includes(searchText);
     });
    }
 }

