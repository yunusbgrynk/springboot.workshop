import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {JwtInterceptor} from "./security/jwt-interceptor";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {ErrorInterceptor} from "./security/authentication.interceptor";
import { LoginComponent } from './login/login.component';
import { SidebarComponent } from './layout/sidebar/sidebar.component';
import {MatIconModule} from "@angular/material";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';

import { CollapseModule } from 'ngx-bootstrap/collapse';
import {ModalModule} from "ngx-bootstrap";
import { HeaderComponent } from './layout/header/header.component';
import { FooterComponent } from './layout/footer/footer.component';
import {DashboardModule} from "./pages/dashboard/dashboard.module";


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SidebarComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxDatatableModule,
    MatIconModule,
    CollapseModule.forRoot(),
    ModalModule.forRoot(),
    BrowserAnimationsModule,
    DashboardModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true}
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
