import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent{

  name:String = undefined;
  password: String = undefined;
  mob_no: number = undefined;
  constructor(private _service : UsersService, private _router : Router){}

  handleRegFormValues(RegFormValues : any){
    this._service.Register(RegFormValues.name,RegFormValues.password,RegFormValues.mob_no)
    .subscribe(response =>{
      console.log(response);
      if(response.id != undefined){
        console.log(response);
        this._router.navigate(["login",response.id]);
      }
      })
  }


}
