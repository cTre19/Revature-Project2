import { Component, OnInit } from '@angular/core';
import { StorageService } from '../storage.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  home = '';
  email = '';
  constructor(
    private storage: StorageService) { }

  ngOnInit() {
    this.email = this.storage.getFromLocal('1').email;
    this.home = '/home' + this.email.substring(0, this.email.indexOf('@'));
  }

  isAdmin(): Boolean {
    if (this.storage.getFromLocal('1') == null) {
      return false;
    }
    if (this.storage.getFromLocal('1').position === 'admin') {
      return true;
    } else {
      return false;
    }

  }

  isLoggedIn(): Boolean {
    if (this.storage.getFromLocal('1') == null) {
      return false;
    }
    return true;
  }
}
