import { Component, OnInit } from '@angular/core';

import { User } from '../_models';
import { Portfolio } from '../_models';

// import { UserService } from '../_services/index';

@Component({
  moduleId: module.id,
  templateUrl: 'home.component.html'
})

export class HomeComponent {
  currentUser: User;
  portfolios: Portfolio;

  constructor() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit(){
  }

  // deleteUser(id: number) {
  //   this.userService.delete(id).subscribe(() => { this.loadAllUsers() });
  // }
  //
  // private loadAllUsers() {
  //   this.userService.getAll().subscribe(users => { this.users = users; });
  // }
  openPortfolio(id: number) {

  }
}
