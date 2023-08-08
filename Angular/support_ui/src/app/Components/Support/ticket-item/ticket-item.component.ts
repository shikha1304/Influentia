import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ResolutionFormComponent } from '../resolution-form/resolution-form.component';
import { ResolutionComponent } from '../resolution/resolution.component';
import { ApisService } from 'src/app/Services/apis.service';
import { TrackTicketComponent } from '../track-ticket/track-ticket.component';
import { faEye } from '@fortawesome/free-solid-svg-icons';
import { faEdit } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-ticket-item',
  templateUrl: './ticket-item.component.html',
  styleUrls: ['./ticket-item.component.css']
})
export class TicketItemComponent implements OnInit{
  faEye = faEye;
  faEdit = faEye;
  @Input() item:any;
  
  constructor (private router: Router, public dialog: MatDialog, private api: ApisService){
  }
  ngOnInit(): void {
    // console.log(this.id);
    if(localStorage.getItem('userName')==='Admin') this.faEdit = faEdit;
  }
  onTrack(){
    this.dialog.open(TrackTicketComponent, {
      width: "30%",
      data: {
        item: this.item
      }
    })
  }

  onResolution(ticketId:number){
    if(localStorage.getItem('userName')===null){
      this.router.navigate(['/login']);
    }
    else if(localStorage.getItem('userName')==="Admin"){
      this.dialog.open(ResolutionFormComponent, {
        width: "30%",
        data: {
          id: this.item.ticketId
        }
      })
    }
    else{
      
      // console.log(this.ticketRes);
      this.dialog.open(ResolutionComponent, {
        width: "30%",
        data: {
          item: this.item
        }
      });
    }   
  }
}
