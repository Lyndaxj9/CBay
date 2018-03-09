import { Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { CartComponent } from './components/cart/cart.component';
import { ItemsearchComponent } from './components/itemsearch/itemsearch.component';
import { SingleitemComponent } from './components/singleitem/singleitem.component';
import { MessagelistComponent } from './components/messagelist/messagelist.component';
import { MessageComponent } from './components/message/message.component';
import { ProfileComponent } from './components/profile/profile.component';
import {ItemsComponent } from './components/items/items.component';
import {AdditemComponent} from './components/additem/additem.component';
import {UsersComponent} from './components/users/users.component';
import {TransactionsComponent} from './components/transactions/transactions.component';
import {ReviewsComponent} from './components/reviews/reviews.component';
import {CarttempComponent} from './components/carttemp/carttemp.component';

export const appRoutes: Routes = [
    {
        path: 'profile/:id',
        component: ProfileComponent
    },
    {
        path: 'searchresults',
        component: ItemsearchComponent
    },
    {
        path: 'item/:id',
        component: SingleitemComponent
    },
    {
        path: 'profile/:id/additem',
        component: AdditemComponent
    },
    {
        path: 'messages',
        component: MessagelistComponent
    },
    {
        path: 'messages/thread',
        component: MessageComponent
    },
    {
        path: 'cart',
        component: CartComponent
    },
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'list/item',
        component: ItemsComponent
    },
    {
      path: 'list/user',
      component: UsersComponent
    },
    {
      path: 'list/transaction',
      component: TransactionsComponent
    },
    {
      path: 'list/review',
      component: ReviewsComponent
    }
    /*
    {
      path: 'list/cart',
      component:CarttempComponent
    }
        create path for homepage
        and maybe one for page not found
    */
];
