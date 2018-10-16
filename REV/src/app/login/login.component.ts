import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Observable } from 'rxjs';
import { Credentials } from '../credentials';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  title = 'Revature Employee Vessel';
  email: '';
  pass: '';
  credentials: Credentials;

  constructor(private loginService: LoginService) {}

  ngOnInit() {
  }

  postCredentials(): void {
    console.log(this.email + ' ' + this.pass);
    const c = new Credentials(this.email, this.pass);

    console.log(c);

    this.loginService.postLogin(c).subscribe(

    );
    /*if (!this.c) { return; } */
   }

}
