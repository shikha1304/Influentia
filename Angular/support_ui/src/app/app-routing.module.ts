import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAccountComponent } from './Components/Account/add-account/add-account.component';
import { ListAccountComponent } from './Components/Account/list-account/list-account.component';
import { RemoveAccountComponent } from './Components/Account/remove-account/remove-account.component';
import { AnalyticsComponent } from './Components/Content/analytics/analytics.component';
import { CreatePostComponent } from './Components/Content/create-post/create-post.component';
import { PostListComponent } from './Components/Content/post-list/post-list.component';
import { HomeComponent } from './Components/home/home.component';
import { LoginComponent } from './Components/login/login.component';
import { SignupComponent } from './Components/signup/signup.component';
import { CancelComponent } from './Components/Subscription/cancel/cancel.component';
import { PurchaseComponent } from './Components/Subscription/purchase/purchase.component';
import { RenewComponent } from './Components/Subscription/renew/renew.component';
import { SubscriptionDetailsComponent } from './Components/Subscription/subscription-details/subscription-details.component';
import { NewTicketComponent } from './Components/Support/new-ticket/new-ticket.component';
import { ResolutionFormComponent } from './Components/Support/resolution-form/resolution-form.component';
import { ResolutionComponent } from './Components/Support/resolution/resolution.component';
import { TicketsListComponent } from './Components/Support/tickets-list/tickets-list.component';
import { TrackTicketComponent } from './Components/Support/track-ticket/track-ticket.component';


const routes: Routes = [
  {
    path:"",
    component:HomeComponent
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
  },
  {
    path:"resolve",
    component:ResolutionComponent
  },
  {
    path:"form/resolve",
    component:ResolutionFormComponent
  },
  {
    path:"subscription/purchase",
    component:PurchaseComponent
  },
  {
    path:"subscription/details",
    component:SubscriptionDetailsComponent
  },
  {
    path:"subscription/renew",
    component:RenewComponent
  },
  {
    path:"subscription/cancel",
    component:CancelComponent
  },
  {
    path:"account/add",
    component:AddAccountComponent
  },
  {
    path:"account/list",
    component:ListAccountComponent
  },
  {
    path:"account/remove",
    component:RemoveAccountComponent
  },
  {
    path:"post/create",
    component:CreatePostComponent
  },
  {
    path:"post/list",
    component:PostListComponent
  },
  {
    path:"post/analytics",
    component:AnalyticsComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
