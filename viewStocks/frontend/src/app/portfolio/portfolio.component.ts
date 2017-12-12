import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PortfolioService } from '../_services';


@Component({
  moduleId: module.id,
  templateUrl: 'portfolio.component.html'
})

export class PortfolioComponent {
  list: any;
  model: any = {};
  loading = false;

  constructor(private router: Router,
              private portfolioService: PortfolioService) {

  }

  ngOnInit() {
    this.model.getOwnedPortfolios().subscribe(
      data => {
        this.model = JSON.stringify(data);
        alert(this.model);
        this.list = data;
      },
      error => console.log(error),
        () => console.log("done")
    );
  }



  add() {
    this.loading = true;
    this.portfolioService.add(this.model).subscribe(
      data => {
        this.router.navigate(['/']);
      },
      error => console.log(error),
      () => console.log("done")
    );
  }
}
