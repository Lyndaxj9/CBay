import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';

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
    SingleitemComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
