import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {FirstentityComponent} from "./firstentity.component";


const routes: Routes = [
  {
    path: '',
    component: FirstentityComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FirstentityRoutingModule { }
