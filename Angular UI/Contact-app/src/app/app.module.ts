import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegistrationComponent } from './registration/registration.component';
import {Routes, RouterModule} from '@angular/router';
import{HttpClientModule} from '@angular/common/http';
import { SuccessComponent } from './success/success.component';
import { ShowContactComponent } from './show-contact/show-contact.component';
let routes : Routes = [
  {path : "login",component:LoginComponent},
  {path : "login/:userId",component:LoginComponent},
  {path:"success/:userId", component:SuccessComponent},
  {path: "register", component: RegistrationComponent},
  {path: "showContact", component: ShowContactComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    ShowContactComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
