import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  users : any = []
  constructor(private _http : HttpClient) {}

  authenticate(userId: number, password : String) : Observable<any>{
    let uri = `http://localhost:8080/login/objectKey/${userId}/${password}`;
    return this._http.get(uri,{})
  }

  Register(name: String, password : String, mob_no : number) : Observable<any>{
    let uri = 'http://localhost:8080/user';
    return this._http.post(uri,{name,password,mob_no});
  }
  login(userId: number, password: String) :boolean {
    if((userId==1000) && password =='angular'){
      return true;
    }
    else{
      return false;
    }
   }
}
