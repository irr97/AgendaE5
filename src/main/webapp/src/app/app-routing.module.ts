import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ReunionesComponent } from './reuniones/reuniones.component';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule } from '@angular/forms';


const routes: Routes = [
  {
    path:'',
    redirectTo: 'Login',
    pathMatch: 'full'
  },
  {
    path: 'Login', component: LoginComponent
  },
  {
    path: 'reuniones', component: ReunionesComponent
  }
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes), ReactiveFormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
