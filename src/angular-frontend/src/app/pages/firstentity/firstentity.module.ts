import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FirstentityRoutingModule} from "./firstentity.routing.module";
import {FirstentityComponent} from "./firstentity.component";

@NgModule({
  imports: [
    CommonModule,
    FirstentityRoutingModule

  ],
  declarations: [FirstentityComponent]
})
export class FirstentityModule { }
