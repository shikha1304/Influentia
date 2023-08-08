import { Component, Inject, Input, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ApisService } from 'src/app/Services/apis.service';


@Component({
  selector: 'app-resolution',
  templateUrl: './resolution.component.html',
  styleUrls: ['./resolution.component.css']
})
export class ResolutionComponent implements OnInit{
  input: any;
  ticketRes: any;
  id=0;
  
  ngOnInit(): void {
    this.input = this.data;  
    console.log(this.input.item.ticketId);
    this.id = this.input.item.ticketId;
    this.api.getTicketRes(this.id).subscribe((data)=>{
      this.ticketRes = data;    
    })
    console.log(this.ticketRes);
  }

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,private api: ApisService,
     private dialog: MatDialog){

  }


}
