import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {URL} from '../_constants';
import {Portfolio} from '../_models';

@Injectable()
export class PortfolioService {
  constructor(private http: HttpClient) {
  }

  add(portfolio: Portfolio) {
    return this.http.post(`${URL}/portfolio/add`, portfolio);
  }

  delete(portfolio: Portfolio) {
    // return this.http.delete(`${URL}/portfolio/delete`, portfolio);
  }

  update(portfolio: Portfolio) {
    return this.http.put(`${URL}/portfolio/update`, portfolio);
  }

  findById(portfolio: Portfolio) {
    return this.http.get(`${URL}/portfolio/get?portfolioId=${portfolio.id}`);
  }

  getOwnedPortfolios(portfolio: Portfolio) {
    return this.http.get(`${URL}/portfolio/getOwnedPortfolios?userId=${portfolio.owner.id}`);
  }

}
