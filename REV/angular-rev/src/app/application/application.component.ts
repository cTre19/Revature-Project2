import { Component, OnInit } from '@angular/core';
import { ApplicationService } from '../application.service';
import { Observable } from 'rxjs';
import { User } from '../user';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.css']
})
export class ApplicationComponent implements OnInit {

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

  constructor(private applicationService: ApplicationService) {}

  ngOnInit() {
  }

  postApplication(): void {
    console.log(this.first + ' ' + this.last);
    const u = new User(this.first, this.last, this.email, this.pass, this.city, this.state, this.client,
      this.batch, this.position);

    console.log(u);

    this.applicationService.postUser(u).subscribe();
    /*if (!this.c) { return; } */
   }
}
