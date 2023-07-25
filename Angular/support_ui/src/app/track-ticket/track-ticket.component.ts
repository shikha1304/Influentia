import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApisService } from '../services/apis.service';

@Component({
  selector: 'app-track-ticket',
  templateUrl: './track-ticket.component.html',
  styleUrls: ['./track-ticket.component.css']
})
export class TrackTicketComponent {

  item:any;
  ticketId: string="";

  constructor(private api: ApisService, private route: ActivatedRoute){

  }

  ngOnInit(){
    this.ticketId = this.route.snapshot.paramMap.get('ticketid')||"";
    this.api.ticketlistbyid(parseInt(this.ticketId)).subscribe((data)=>{
      this.item=data;
    })
  }
}
