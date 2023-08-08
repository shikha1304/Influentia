import { Component, Inject, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApisService } from 'src/app/Services/apis.service';
import { MatDialog, MatDialogConfig, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ResolutionComponent } from '../resolution/resolution.component';

@Component({
  selector: 'app-track-ticket',
  templateUrl: './track-ticket.component.html',
  styleUrls: ['./track-ticket.component.css']
})
export class TrackTicketComponent implements OnInit{

  inputData:any;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,private api: ApisService, private route: ActivatedRoute, private router: Router,
     private dialog: MatDialog){

  }
  
  ngOnInit(){
    this.inputData = this.data;
  }
}
