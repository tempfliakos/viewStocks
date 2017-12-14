import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { URL } from '../_constants';
import { User } from '../_models';
import * as url from 'url';

@Injectable()
export class UserService {

  constructor(private http: HttpClient) { }

  register(user: User) {
    return this.http.post(`${URL}/user/register`, user);
  }

  update(user: User) {
    return this.http.post(`${URL}/user/update`, user);
  }
}
