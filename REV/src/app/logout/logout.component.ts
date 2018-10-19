import { Component, OnInit } from '@angular/core';
import { LOCAL_STORAGE } from 'angular-webstorage-service';
import { StorageService } from '../storage.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
    private storage: StorageService) { }

  ngOnInit() {
    this.storage.saveInLocal('1', null);
    location.replace('/login');
  }

}
