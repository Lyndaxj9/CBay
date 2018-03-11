import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { StarRatingModule } from 'angular-star-rating';

import { appRoutes } from './routing';
// Components
import { EntityDisplayComponent } from './components/entitydisplay/entitydisplay.component';
import { MessageComponent } from './components/message/message.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ItemsearchComponent } from './components/itemsearch/itemsearch.component';
import { CartComponent } from './components/cart/cart.component';
import { LogintempComponent } from './components/logintemp/logintemp.component';
import { RegistertempComponent } from './components/registertemp/registertemp.component';
import { HomeComponent } from './components/home/home.component';
import { SingleitemComponent } from './components/singleitem/singleitem.component';
import { MessagelistComponent } from './components/messagelist/messagelist.component';
import { AdditemComponent } from './components/additem/additem.component';
import { TransactionsComponent } from './components/transactions/transactions.component';
import { UsersComponent } from './components/users/users.component';
import { ItemsComponent } from './components/items/items.component';
import { ReviewsComponent } from './components/reviews/reviews.component';
import { CarttempComponent } from './components/carttemp/carttemp.component';
import { OrderComponent } from './components/order/order.component';


@NgModule({
  declarations: [
    AppComponent,
    EntityDisplayComponent,
    MessageComponent,
    ProfileComponent,
    ItemsearchComponent,
    CartComponent,
    LogintempComponent,
    RegistertempComponent,
    HomeComponent,
    SingleitemComponent,
    MessagelistComponent,
    AdditemComponent,
    TransactionsComponent,
    UsersComponent,
    ItemsComponent,
    ReviewsComponent,
    CarttempComponent,
    OrderComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    StarRatingModule.forRoot(),
      ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
