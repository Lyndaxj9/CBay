import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-genericlist',
  templateUrl: './genericlist.component.html',
  styleUrls: ['./genericlist.component.css']
})
export class GenericlistComponent implements OnInit {
  list = ['', '', '', '', '', ''];
  constructor() { }

  ngOnInit() {
  }

}
