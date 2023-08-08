import { Component } from '@angular/core';
import { faEye } from '@fortawesome/free-solid-svg-icons';
import { MatDialog } from '@angular/material/dialog';
import { SubscriptionApiService } from 'src/app/Services/subscription-api.service';
import { DiscountsComponent } from '../discounts/discounts.component';
import { PlansComponent } from '../plans/plans.component';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent {
 eye = faEye 

 constructor(public dialog: MatDialog){

 }

 viewPlans(){
  this.dialog.open(PlansComponent,{
    width: "40%"
  });
 }

 viewDiscounts(){
  this.dialog.open(DiscountsComponent, {
    width: "35%"
  });
 }
}
