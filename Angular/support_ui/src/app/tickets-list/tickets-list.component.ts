import { Component } from '@angular/core';
import { ApisService } from '../services/apis.service';
// import { ticketDTO } from '../support/supportDto';
@Component({
  selector: 'app-tickets-list',
  templateUrl: './tickets-list.component.html',
  styleUrls: ['./tickets-list.component.css']
})
export class TicketsListComponent {
  // ticketList: ticketDTO[]=[];
  list:any;

  
  constructor(private api: ApisService){

  }

  ngOnInit(){
    this.api.ticketlistbyadmin().subscribe((data)=>{
      this.list=data;
    })
  }
}
