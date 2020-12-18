import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router'
import { UsersService } from '../users.service';
@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css']
})
export class SuccessComponent implements OnInit {

  userId: number=undefined;
  constructor(private _activatedRoute : ActivatedRoute) { }
  constructor(private _service : UsersService){}
  ngOnInit(): void {
    this._activatedRoute.params.subscribe((key : Params) => this.userId = key.userId);
  }

}