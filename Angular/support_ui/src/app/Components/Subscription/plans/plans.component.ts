import { Component, OnInit } from '@angular/core';
import { SubscriptionApiService } from 'src/app/Services/subscription-api.service';

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css']
})
export class PlansComponent implements OnInit{

  items: any;
  
  constructor(private api: SubscriptionApiService){

  }
  ngOnInit(){
    this.api.getSubscriptionPlans().subscribe((data)=>{
      this.items = data;
      console.log(data);
    })
  }
}
