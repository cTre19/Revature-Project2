import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ApplicationComponent } from './application/application.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { ViewappsComponent } from './viewapps/viewapps.component';
import { ViewempsComponent } from './viewemps/viewemps.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'application', component: ApplicationComponent},
  { path: 'home', component: HomeComponent},
  { path: 'logout', component: LogoutComponent},
  { path: 'viewapps', component: ViewappsComponent},
  { path: 'viewemps', component: ViewempsComponent}
];

@NgModule({
  exports: [ RouterModule ],
  imports: [
    RouterModule.forRoot(routes)
  ],
  declarations: []
})
export class AppRoutingModule { }
