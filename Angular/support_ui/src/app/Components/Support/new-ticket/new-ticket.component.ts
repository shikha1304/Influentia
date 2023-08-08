import { Component, ViewChild } from '@angular/core';
import { FormBuilder, NgForm } from '@angular/forms';
import { ApisService } from 'src/app/Services/apis.service';
import { Router } from '@angular/router';
import {ViewEncapsulation } from '@angular/core';
@Component({
  selector: 'app-new-ticket',
  templateUrl: './new-ticket.component.html',
  styleUrls: ['./new-ticket.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class NewTicketComponent {
  
  ticket = {
    raisedByUserName: '',
    ticketSummary: '',
    ticketDetails: '',
    ticketType: '',
  }

  constructor(private api: ApisService, private router: Router, private buildr: FormBuilder){

  }

  formData = this.buildr.group({
    ticketSummary: this.buildr.control(''),
    ticketDetails: this.buildr.control(''),
    ticketType: this.buildr.control('')
  })

  ngOnInit(){
    if(localStorage.getItem("userName") === null){
      alert("Login Required!!");
      this.router.navigate(["/login"]);
    }
  }
  onSubmit(){
    this.ticket.raisedByUserName = localStorage.getItem('userName')!;
    this.ticket.ticketSummary = this.formData.value.ticketSummary!;
    this.ticket.ticketDetails = this.formData.value.ticketDetails!;
    this.ticket.ticketType = this.formData.value.ticketType!;

    console.log(this.ticket);

    if(!this.ticket.raisedByUserName || !this.ticket.ticketSummary || !this.ticket.ticketDetails || !this.ticket.ticketType){
      window.alert("Please fill all the required fields");
      return;
    }

    this.api.newticket(this.ticket).subscribe((response)=>{
      alert("Raised a new ticket");
    },
    (error)=>{
      alert(error.message);
    })
  }

}
