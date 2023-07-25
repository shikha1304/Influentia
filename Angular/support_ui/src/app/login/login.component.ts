import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ApisService } from '../services/apis.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  @ViewChild('loginFormData') data: NgForm | any;

  user = {
    email: '',
    password: ''
  };

  constructor (private router: Router,private api: ApisService){
  }
  onLogin(){
    this.user.email = this.data.value.email;
    this.user.password = this.data.value.password;
    console.log(this.user);
    if(!this.user.email || !this.user.password){
      window.alert("Please fill all the required fields");
      return;
    }
    this.api.userLogin(this.user).subscribe(
      (response)=>{
        localStorage.setItem('userName', response);
        alert("Login Successful");
        this.router.navigate([""]);
      }
    )
  }
// variable_name = localStorage.getItem("userName");
}
