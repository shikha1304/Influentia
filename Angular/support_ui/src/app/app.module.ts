import { ErrorHandler, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatDialogModule, MatDialogRef} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './Components/header/header.component';
import { HomeComponent } from './Components/home/home.component';
import { LoginComponent } from './Components/login/login.component';
import { SignupComponent } from './Components/signup/signup.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { CustomErrorHandler } from './Services/custom-error-handler.service';
import { TicketsListComponent } from './Components/Support/tickets-list/tickets-list.component';
import { NewTicketComponent } from './Components/Support/new-ticket/new-ticket.component';
import { ResolutionFormComponent } from './Components/Support/resolution-form/resolution-form.component';
import { ResolutionComponent } from './Components/Support/resolution/resolution.component';
import { TicketItemComponent } from './Components/Support/ticket-item/ticket-item.component';
import { TrackTicketComponent } from './Components/Support/track-ticket/track-ticket.component';
import { PurchaseComponent } from './Components/Subscription/purchase/purchase.component';
import { CancelComponent } from './Components/Subscription/cancel/cancel.component';
import { AddAccountComponent } from './Components/Account/add-account/add-account.component';
import { ListAccountComponent } from './Components/Account/list-account/list-account.component';
import { RemoveAccountComponent } from './Components/Account/remove-account/remove-account.component';
import { CreatePostComponent } from './Components/Content/create-post/create-post.component';
import { PostListComponent } from './Components/Content/post-list/post-list.component';
import { AnalyticsComponent } from './Components/Content/analytics/analytics.component';
import { RenewComponent } from './Components/Subscription/renew/renew.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { SubscriptionDetailsComponent } from './Components/Subscription/subscription-details/subscription-details.component';
import { DiscountsComponent } from './Components/Subscription/discounts/discounts.component';
import { PlansComponent } from './Components/Subscription/plans/plans.component';


@NgModule({
  declarations: [
    AppComponent,
    NewTicketComponent,
    TicketsListComponent,
    TrackTicketComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    TicketItemComponent,
    ResolutionComponent,
    ResolutionFormComponent,
    PurchaseComponent,
    CancelComponent,
    AddAccountComponent,
    ListAccountComponent,
    RemoveAccountComponent,
    CreatePostComponent,
    PostListComponent,
    AnalyticsComponent,
    RenewComponent,
    SubscriptionDetailsComponent,
    DiscountsComponent,
    PlansComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatDialogModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatCheckboxModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatButtonModule,
    FontAwesomeModule,
    MatSnackBarModule,
    MatDatepickerModule
  ],
  exports: [
    MatDialogModule
  ],
  providers: [
    //to remove the error: StaticInjectorError[MatDialogRef]: StaticInjectorError[MatDialogRef]: NullInjectorError: No provider for MatDialogRef!
    {
      provide: MatDialogRef,
      useValue: {}
    },
    {
      provide: ErrorHandler,
      useClass: CustomErrorHandler
    }
  ],
  bootstrap: [AppComponent],
  // entryComponents: [ResolutionComponent]
})
export class AppModule { }
