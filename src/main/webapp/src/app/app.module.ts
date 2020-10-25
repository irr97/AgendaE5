import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { LoginComponent } from './login/login.component';


import { ReunionesComponent } from './reuniones/reuniones.component';
import { ReunionesPreComponent } from './reuniones-pre/reuniones-pre.component';

import { HttpClientModule } from '@angular/common/http';
import { MenuComponent } from './menu/menu.component';
import { RegistroComponent } from './registro/registro.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
<<<<<<< HEAD
    MenuComponent,
    RegistroComponent
=======
    ReunionesComponent,
    ReunionesPreComponent,
    MenuComponent


>>>>>>> branch 'login' of https://github.com/RamonDiazRodrigo/AgendaE5.git
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
