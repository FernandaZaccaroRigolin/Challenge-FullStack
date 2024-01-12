import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PoModule } from '@po-ui/ng-components';
import { ChallengeRoutingModule } from './challenge-routing.module';
import { ClientViewComponent } from './presentation/client-view/client-view.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ClientFacadeService } from 'src/app/application/challenge/abstraction/client-facade.service';
import { ClientFormComponent } from './presentation/client-form/client-form.component';

@NgModule({
  declarations: [
    ClientViewComponent,
    ClientFormComponent
  ],
  imports: [
    PoModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    ChallengeRoutingModule
  ],
  providers: [
    ClientFacadeService
  ] 
})
export class ChallengeModule { }
