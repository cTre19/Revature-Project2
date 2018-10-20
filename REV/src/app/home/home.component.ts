import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';
import { LOCAL_STORAGE } from 'angular-webstorage-service';
import { StorageService } from '../storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  name = '';
  constructor(private http: HttpClient,
    private storage: StorageService) { }

  ngOnInit() {
    if (this.storage.getFromLocal('1') == null) {
      location.replace('/login');
    } else {
      this.name = this.storage.getFromLocal('1').firstName;
    }
  }

}
