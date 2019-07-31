import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [

  {
    path:'',
    children: [
      {path:'',pathMatch:'full',redirectTo:'dashboard'},
      {path:'dashboard',loadChildren:'./pages/dashboard/dashboard.module#DashboardModule'},
      {path:'firstentity',loadChildren:'./pages/firstentity/firstentity.module#FirstentityModule'}

    ]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
