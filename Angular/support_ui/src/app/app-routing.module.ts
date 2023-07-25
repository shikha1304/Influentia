import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NewTicketComponent } from './new-ticket/new-ticket.component';
import { SignupComponent } from './signup/signup.component';
import { SupportComponent } from './support/support.component';
import { TicketsListComponent } from './tickets-list/tickets-list.component';
import { TrackTicketComponent } from './track-ticket/track-ticket.component';

const routes: Routes = [
  {
    path:"",
    component:HomeComponent
  },
  {
    path:"support",
    component:SupportComponent
  },
  {
    path:"support/create",
    component:NewTicketComponent
  },{
    path:"support/list",
    component:TicketsListComponent
  },{
    path:"support/track/:ticketid",
    component:TrackTicketComponent
  },
  {
    path:"login",
    component:LoginComponent
  },
  {
    path:"signup",
    component:SignupComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
