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
  email: '';

  constructor(
    private userService: UserService,
    private http: HttpClient,
    private storage: StorageService
   ) {}

  ngOnInit() {
    this.columns = ['firstName', 'lastName', 'email', 'city', 'state', 'client', 'batch_id', 'position', 'approved'];

    this.users = this.userService.getApps();
    console.log(this.users);
  }

  approveUser(user: User): void {
    console.log('approve user: ' + user.email);
    this.userService.update(user).subscribe(data => this.navigate(data));
    // this.users = this.userService.getApps();
  }

  denyUser(user: User): void {
    console.log('deny user:' + user.email.substring(0, user.email.indexOf('@')));
    user.email = user.email.substring(0, user.email.indexOf('@'));
    this.userService.delete(user).subscribe();
    this.navigate2();
  }

  navigate(user: User): void {
    if (user != null) {
      this.users = this.userService.getApps();
      // location.replace('/viewapps');
  }
}

  navigate2(): void {
      location.replace('/viewapps');
    }

}
