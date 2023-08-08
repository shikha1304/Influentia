import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
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
    return this.http.post(this.BaseUrl+"new", ticket, {responseType:'text'});
  }

  ticketlistbyid(ticketId:number){
    return this.http.get(this.BaseUrl+"id/"+ticketId);
  }

  closeticket(ticketRes: any){
    return this.http.put(this.BaseUrl+"resolve", ticketRes,{responseType:'text'});
  }

  userSignUp(userSignUp:any){
    return this.http.post(this.BaseUrl+"registration", userSignUp);
  }

  userLogin(userLogin:any){
    return this.http.post(this.BaseUrl+"login", userLogin,{responseType:'text'});
  }

  getTicketRes(id:number){
    return this.http.get(this.BaseUrl+"res/"+id);
  }


  // private handleError(error: HttpErrorResponse) {
  //   let errorMessage='';
  //   if (error.status === 0) {
  //     // A client-side or network error occurred. Handle it accordingly.
  //     console.error('An error occurred:', error.error);
  //     errorMessage = `An error occurred: ${error.error}`
  //   } 

  //   else {
  //     // The backend returned an unsuccessful response code.
  //     // The response body may contain clues as to what went wrong.
  //     console.error(
  //       `Backend returned code ${error.status}, body was: `, error.error);
  //       errorMessage = `Backend returned code ${error.status}, body was: ${error.error.message}`
  //   }
  //   // Return an observable with a user-facing error message.
  //   // errorMessage += 'Something bad happened; please try again later.';
  //   return throwError(errorMessage);

  //   // () => new Error('Something bad happened; please try again later.')
  // }
}
