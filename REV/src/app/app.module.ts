import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Pipe } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { MessagesComponent } from './messages/messages.component';
import { ApplicationComponent } from './application/application.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { NavComponent } from './nav/nav.component';
import { StorageServiceModule } from 'angular-webstorage-service';
import { StorageService } from './storage.service';
import { LogoutComponent } from './logout/logout.component';
import { ViewappsComponent } from './viewapps/viewapps.component';
import { ViewempsComponent } from './viewemps/viewemps.component';
import { FilterPipe } from './viewemps/viewemps.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MessagesComponent,
    ApplicationComponent,
    HomeComponent,
    NavComponent,
    LogoutComponent,
    ViewappsComponent,
    ViewempsComponent,
    FilterPipe

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    StorageServiceModule
  ],
  providers: [StorageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
