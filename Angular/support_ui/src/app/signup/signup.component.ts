import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ApisService } from '../services/apis.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  @ViewChild('register') userData: NgForm | any;

  user = {
    userName: '',
    email: '',
    password: '',
    userType: 'user'
  };

  constructor (private router: Router,private api: ApisService){
  }
  
  onSubmit(){
    this.user.userName = this.userData.value.userName;
    this.user.email = this.userData.value.email;
    this.user.password = this.userData.value.password;
    console.log(this.user);
    if(!this.user.userName || !this.user.email || !this.user.password){
      window.alert("Please fill all the required fields");
      return;
    }
    this.api.userSignUp(this.user).subscribe(
      ()=>{
        alert("Registered");
        this.router.navigate(['login']);
      }
    )
  }
  
}
