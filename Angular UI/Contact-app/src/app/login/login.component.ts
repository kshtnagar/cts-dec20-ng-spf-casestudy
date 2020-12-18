import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UsersService } from '../users.service';
import{Router} from '@angular/router'
import { lookup } from 'dns';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent{

  userId: number = undefined;
  password: String = undefined;
  constructor(private _service : UsersService, private _router : Router){}

  handleFormValues(formValues : any){
    this._service.authenticate(formValues.userId,formValues.password)
    .subscribe(response =>{
      console.log(response);
      if(response.id != undefined){
        this._router.navigate(["success",formValues.userId]);
      }
      })
  }

}
