import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientViewComponent } from './presentation/client-view/client-view.component';
import { ClientFormComponent } from './presentation/client-form/client-form.component';

const routes: Routes = [
  {
    path: '', 
    component:ClientViewComponent
  },
  {
    path: 'new', 
    component:ClientFormComponent
  }  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ChallengeRoutingModule { }
