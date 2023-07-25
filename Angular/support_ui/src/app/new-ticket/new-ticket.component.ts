import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ApisService } from '../services/apis.service';

@Component({
  selector: 'app-new-ticket',
  templateUrl: './new-ticket.component.html',
  styleUrls: ['./new-ticket.component.css']
})
export class NewTicketComponent {
  @ViewChild('add') formData: NgForm | any;

  ticket = {
    userName: '',
    ticketSummary: '',
    ticketDetails: '',
    ticketType: '',
  }

  constructor(private api: ApisService){

  }
  onSubmit(){
    this.ticket.userName = this.formData.userName.value;
    this.ticket.ticketSummary = this.formData.ticketSummary.value;
    this.ticket.ticketDetails = this.formData.ticketDetails.value;
    this.ticket.ticketType = this.formData.ticketType.value;

    console.log(this.ticket);

    if(!this.ticket.userName || !this.ticket.ticketSummary || !this.ticket.ticketDetails || !this.ticket.ticketType){
      window.alert("Please fill all the required fields");
      return;
    }

    this.api.newticket(this.ticket).subscribe(()=>{
      alert("Raised a new ticket");
    })
  }

}
