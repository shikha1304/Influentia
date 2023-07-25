import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ticket-item',
  templateUrl: './ticket-item.component.html',
  styleUrls: ['./ticket-item.component.css']
})
export class TicketItemComponent {
  @Input() item:any;
  constructor (private router: Router){
  }
  onTrack(){
    this.router.navigate(["/support/track/",this.item.ticketId]);
  }
}
