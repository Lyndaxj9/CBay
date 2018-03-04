import { Component } from '@angular/core';

@Component({
    selector: 'app-entity-display',
    templateUrl: './entitydisplay.component.html'
})

export class EntityDisplayComponent {
    data = 'name';
    dbresult = [
        2, 'Bobbert', 'seller', 'b@gmail.com', 'I am a very trustworthy seller', '4.5/5'
    ]
    canEdit: boolean = true;
}
