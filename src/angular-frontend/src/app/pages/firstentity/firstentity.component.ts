import { Component, OnInit } from '@angular/core';
import {FirstentityService} from "../../services/firstentity.service";
import {Page} from "../../common/page";
import {FirstentityModel} from "../../common/firstentity.model";

@Component({
  selector: 'app-firstentity',
  templateUrl: './firstentity.component.html',
  styleUrls: ['./firstentity.component.css']
})
export class FirstentityComponent implements OnInit {

  page = new Page();
  rows = new Array<FirstentityModel>();
  constructor(private firstEntityService: FirstentityService) {

  }

  ngOnInit() {
    this.setPage({ offset: 0 });
  }
  setPage(pageInfo) {
    this.page.number = pageInfo.offset;
    this.firstEntityService.getAll(this.page).subscribe(pageData => {
      this.page.size = pageData.size;
      this.page.number   = pageData.number;
      this.page.totalElements = pageData.totalElements;
      this.rows = pageData.content;
    });
  }

}
