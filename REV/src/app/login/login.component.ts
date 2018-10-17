import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Observable } from 'rxjs';
import { NavigationEnd } from '@angular/router';
import { User } from '../user';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  url = 'http://localhost:8080/REVjava/home';

  title = 'Revature Employee Vessel';
  loginerror = 'noborder';

  error = '';
  email: '';
  pass: '';
  user: User;

  constructor(
    private loginService: LoginService,
    private http: HttpClient
    ) { }

  ngOnInit() {
  }

  postCredentials(): void {
    console.log(this.email + ' ' + this.pass);
    const u = new User(this.email, this.pass);

    console.log(u);

    this.loginService.postLogin(u).subscribe(data => this.navigate(data));
  }

  navigate(user: User): void {
    if (user == null) {
      this.error = 'Incorrect email or password, please try again!';
      this.loginerror = 'redborder';
    } else {
      location.replace('/home');
    }
  }

}
