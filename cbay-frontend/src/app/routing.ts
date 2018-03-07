import { Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { CartComponent } from './components/cart/cart.component';
import { ItemsearchComponent } from './components/itemsearch/itemsearch.component';
import { MessageComponent } from './components/message/message.component';
import { ProfileComponent } from './components/profile/profile.component';

export const appRoutes: Routes = [
    {
        path: 'profile',
        component: ProfileComponent
    },
    {
        path: 'items',
        component: ItemsearchComponent
    },
    {
        path: 'messages',
        component: MessageComponent
    },
    {
        path: 'cart',
        component: CartComponent
    },
    {
        path: '',
        component: HomeComponent
    }
    /*
        create path for homepage
        and maybe one for page not found
    */
];