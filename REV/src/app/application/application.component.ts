import { Component, OnInit } from '@angular/core';
import { ApplicationService } from '../application.service';
import { Observable } from 'rxjs';
import { User } from '../user';
import { NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.css']
})
export class ApplicationComponent implements OnInit {

  title = 'Revature Employee Vessel';
  error = 'noborder';
  errormsg = '';

  first: '';
  last: '';
  email: '';
  pass: '';
  city: '';
  state: '';
  client: '';
  batch: 0;
  position: '';
  user: User;

  constructor(private applicationService: ApplicationService) { }

  ngOnInit() {
  }

  postApplication(): void {
    console.log(this.first + ' ' + this.last);
    const u = new User(this.first, this.last, this.email, this.pass, this.city, this.state, this.client,
      this.batch, this.position);

    console.log(u);

    this.applicationService.postUser(u).subscribe(data => this.navigate(data));
    }

    navigate(user: User): void {
      if (user != null) {
      location.replace('/login');
    } else {
      this.errormsg = 'This email is already registered, please log in or try another email!';
      this.error = 'redborder';
    }
  }
}
