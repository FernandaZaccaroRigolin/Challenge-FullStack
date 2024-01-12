import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'client',
    loadChildren: () => import('./infrastructure/challenge/challenge.module').then((m) => m.ChallengeModule),
    data: {
      breacrumb: {items:[{ label: 'Início', link: 'portal' }, { label: 'Configurador', link: ''}]}
    }
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
