import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PortfolioService } from '../_services';


@Component({
  moduleId: module.id,
  templateUrl: 'portfolio.component.html'
})

export class PortfolioComponent {
  model: any = {};
  loading = false;

  constructor(private router: Router,
              private portfolioService: PortfolioService) {
  }

  add() {
    this.loading = true;
    this.portfolioService.add(this.model).subscribe(
      data => {
        this.router.navigate(['/portfolio']);
      },
      error => {
        this.loading = false;
      });
  }
}
