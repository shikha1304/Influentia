import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class SubscriptionApiService {

  constructor(private http: HttpClient) { 

  }

  BaseUrl = 'http://localhost:3000/api/subscriptions';

  getSubscription(userName: string){
    return this.http.get(this.BaseUrl+'/plan/'+userName);
  }

  getSubscriptionPlans(){
    return this.http.get(this.BaseUrl+'/plan');
  }
}
