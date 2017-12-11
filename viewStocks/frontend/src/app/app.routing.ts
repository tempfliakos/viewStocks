import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { PortfolioComponent } from './portfolio';
// import { WatchlistComponent } from './watchlist';
import { AuthGuard } from './_guards';

const appRoutes: Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'portfolio', component: PortfolioComponent },
  // { path: 'watclist', component: WatchlistComponent},

  { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);
