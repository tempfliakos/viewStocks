import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { URL } from '../_constants';
import { Portfolio } from '../_models/portfolio';

@Injectable()
export class PortfolioService {
  constructor(private http: HttpClient) { }

  add(portfolio: Portfolio) {
    return this.http.post(`${URL}/portfolio/add`, portfolio);
  }

  delete(portfolio: Portfolio) {
    return this.http.post(`${URL}/portfolio/delete`, portfolio);
  }

  update(portfolio: Portfolio) {
    return this.http.post(`${URL}/portfolio/update`, portfolio);
  }

  findById(id: number) {
    return this.http.post(`${URL}/portfolio/get`, id);
  }

  getOwnedPortfolios(id: number) {
    return this.http.post(`${URL}/portfolio/getOwnedPortfolios`, id);
  }

}
