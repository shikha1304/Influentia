import { Component } from '@angular/core';
import { ApisService } from 'src/app/Services/apis.service';
import { Router } from '@angular/router';
import { faPlus } from '@fortawesome/free-solid-svg-icons';
import { NewTicketComponent } from '../new-ticket/new-ticket.component';
import { MatDialog } from '@angular/material/dialog';

// import { ticketDTO } from '../support/supportDto';
@Component({
  selector: 'app-tickets-list',
  templateUrl: './tickets-list.component.html',
  styleUrls: ['./tickets-list.component.css']
})
export class TicketsListComponent {
  // ticketList: ticketDTO[]=[];
  list:any;
  plus = faPlus;
  error : string | undefined = undefined
  constructor(private api: ApisService, private router: Router, public dialog: MatDialog){

  }

  user = localStorage.getItem('userName');

  ngOnInit(){
    if(this.user === "Admin"){
      this.api.ticketlistbyadmin().subscribe((data)=>{
        this.list=data;
      })
    }

    else if(this.user === null){
      alert("Login Required!!");
      this.router.navigate(["/login"]);
    }

    else{
      this.api.ticketlistbyuser(this.user).subscribe((data)=>{
        this.list=data;
      })
    }
    
  }

  userLogin(){
    return !((this.user === 'Admin') || (this.user === null));
  }

  openForm(){
    this.dialog.open(NewTicketComponent)
  }
}
