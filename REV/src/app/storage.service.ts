import { Injectable } from '@angular/core';
import { LOCAL_STORAGE, WebStorageService } from 'angular-webstorage-service';
import { User } from './user';
import { Inject } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor(@Inject(LOCAL_STORAGE) private storage: WebStorageService) { }

  public data: any = [];

  saveInLocal(u: string, user: User): void {
    console.log('recieved: ' + user);
    this.storage.set(u, user);
    this.data[u] = this.storage.get(u);
  }

  getFromLocal(u): User {
    console.log('recieved: ' + u);
    this.data[u] = this.storage.get(u);
    console.log(this.data);
    return this.data[u];
  }
}
