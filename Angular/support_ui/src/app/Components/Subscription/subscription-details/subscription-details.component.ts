import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { SubscriptionApiService } from 'src/app/Services/subscription-api.service';
import { CancelComponent } from '../cancel/cancel.component';
import { RenewComponent } from '../renew/renew.component';

@Component({
  selector: 'app-subscription-details',
  templateUrl: './subscription-details.component.html',
  styleUrls: ['./subscription-details.component.css']
})
export class SubscriptionDetailsComponent implements OnInit{

  user = localStorage.getItem('userName');

  constructor(public router: Router, public dialog: MatDialog, private api:SubscriptionApiService){

  }
  
  date = new Date()

  subscriptionPlan: any = {
    subscriptionId: 0,
    username: '',
    planid: {
      name: '',
      planId: 0,
      pricepermonth: 0
    },
    subscriptionStartDate: this.date,
    subscriptionEndDate: this.date,
    amountPaid: 0,
    paymentMode: '',
    subscriptionstatus: ''
  }

  ngOnInit(){

    if(this.user === null){
      this.router.navigate(['/login']);
    }

    console.log('Hello')
    this.user = localStorage.getItem('userName')!;
    this.api.getSubscription(this.user).subscribe((data)=>{
      this.subscriptionPlan = data;
      // console.log(data)
    })
    // console.log(this.subscriptionPlan)
  }
  onRenew(){
    this.dialog.open(RenewComponent, {
      width: "30%"
    })
  }

  onCancel(){
    this.dialog.open(CancelComponent,{
      width: "30%"
    })
  }
}
