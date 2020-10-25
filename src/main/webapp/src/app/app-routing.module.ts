import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
<<<<<<< HEAD
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
=======
import { ReunionesComponent } from './reuniones/reuniones.component';
>>>>>>> branch 'login' of https://github.com/RamonDiazRodrigo/AgendaE5.git

<<<<<<< HEAD
const routes: Routes = [
  {
    path:"", redirectTo:"Login", pathMatch:'full'
  },
  {
    path:"Login", component:LoginComponent
  },
  {
    path:"registro", component:RegistroComponent
  }

=======

const routes: Routes = [
  {
    path:'',
    redirectTo: '/reuniones',
    pathMatch: 'full'
  },
  {
    path: 'reuniones', component: ReunionesComponent
  }
>>>>>>> branch 'login' of https://github.com/RamonDiazRodrigo/AgendaE5.git
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
