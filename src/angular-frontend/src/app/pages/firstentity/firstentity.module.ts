import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FirstentityRoutingModule} from "./firstentity.routing.module";
import {FirstentityComponent} from "./firstentity.component";
import {FirstentityService} from "../../services/firstentity.service";

@NgModule({
  imports: [
    CommonModule,
    FirstentityRoutingModule

  ],
  providers: [FirstentityService],
  declarations: [FirstentityComponent]
})
export class FirstentityModule { }
