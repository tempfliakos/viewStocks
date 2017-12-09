import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';

import { URL } from '../_constants/';

@Injectable()
export class AuthenticationService {
  constructor(private http: HttpClient) {
  }

  login(user: any) {
    return this.http.post(`${URL}/user/login`, user)
      .map(loggedInUser => {
        if (loggedInUser) {
          localStorage.setItem('currentUser', JSON.stringify(loggedInUser));
        }
      });
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }
}
