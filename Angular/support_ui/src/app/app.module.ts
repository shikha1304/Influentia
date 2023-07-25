import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NewTicketComponent } from './new-ticket/new-ticket.component';
import { TicketsListComponent } from './tickets-list/tickets-list.component';
import { TrackTicketComponent } from './track-ticket/track-ticket.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { SupportComponent } from './support/support.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { TicketItemComponent } from './ticket-item/ticket-item.component';

@NgModule({
  declarations: [
    AppComponent,
    NewTicketComponent,
    TicketsListComponent,
    TrackTicketComponent,
    HeaderComponent,
    HomeComponent,
    SupportComponent,
    LoginComponent,
    SignupComponent,
    TicketItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
