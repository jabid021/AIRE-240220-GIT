import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _username: string;
  private _password: string;
  
  public get username(): string {
    return this._username;
  }
  
  public set username(v: string) {
    this._username = v;
  }
  
  public get password(): string {
    return this._password;
  }

  public set password(v: string) {
    this._password = v;
  }

  constructor() {
    this._username = "user";
    this._password = "123456$";
  }
}
