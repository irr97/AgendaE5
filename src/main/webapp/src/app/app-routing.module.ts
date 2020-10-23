import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ReunionesComponent } from './reuniones/reuniones.component';


const routes: Routes = [
  {
    path:'',
    redirectTo: '/reuniones',
    pathMatch: 'full'
  },
  {
    path: 'reuniones', component: ReunionesComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
