import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { UserListComponent } from './user-list/user-list.component';
import { TechnicienComponent } from './technicien/technicien.component';
import { EquipementComponent } from './equipement/equipement.component';
import { PanneComponent } from './panne/panne.component';
import { InterventionComponent } from './intervention/intervention.component';
const routes: Routes = [{
  path: '',
  component: HomeComponent,
},

{
  path: 'users', 
  component: UserListComponent
},
{
  path: 'technicien', 
  component: TechnicienComponent
},
{
  path: 'equipement', 
  component: EquipementComponent
},

{
  path:'panne',
  component: PanneComponent
},
{
  path:'intervention',
  component: InterventionComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
