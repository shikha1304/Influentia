import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ApisService {
  BaseUrl="http://localhost:8080/api/tickets/";
  constructor(
    private http: HttpClient
  ) { }

  ticketlistbyadmin(){
    return this.http.get(this.BaseUrl + "view/list-new");
  }

  ticketlistbyuser(userName:string){
    return this.http.get(this.BaseUrl + "name/"+userName);
  }
  
  newticket(ticket: any){
    return this.http.post(this.BaseUrl+"new", ticket);
  }

  ticketlistbyid(ticketId:number){
    return this.http.get(this.BaseUrl+"id/"+ticketId);
  }

  closeticket(ticketId:number){
    return this.http.get(this.BaseUrl+ticketId+"/resolve");
  }

  userSignUp(userSignUp:any){
    return this.http.post(this.BaseUrl+"registration", userSignUp);
  }

  userLogin(userLogin:any){
    return this.http.post(this.BaseUrl+"login", userLogin,{responseType:'text'});
  }
}
