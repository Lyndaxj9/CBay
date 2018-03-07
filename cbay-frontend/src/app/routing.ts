import { Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { CartComponent } from './components/cart/cart.component';
import { ItemsearchComponent } from './components/itemsearch/itemsearch.component';
import { SingleitemComponent } from './components/singleitem/singleitem.component';
import { MessageComponent } from './components/message/message.component';
import { ProfileComponent } from './components/profile/profile.component';

export const appRoutes: Routes = [
    {
        path: 'profile',
        component: ProfileComponent
    },
    {
        path: 'searchresults',
        component: ItemsearchComponent
    },
    {
        path: 'item',
        component: SingleitemComponent
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
