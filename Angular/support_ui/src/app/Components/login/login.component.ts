import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ApisService } from 'src/app/Services/apis.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  @ViewChild('loginFormData') formData: NgForm | any;

  user = {
    email: '',
    password: ''
  };

  constructor (private router: Router,private api: ApisService){
  }
  onLogin(){
    this.user.email = this.formData.value.email;
    this.user.password = this.formData.value.password;
    console.log(this.user);
    if(!this.user.email || !this.user.password){
      window.alert("Please fill all the required fields");
      return;
    }
    this.api.userLogin(this.user).subscribe(
      (response)=>{
        localStorage.setItem('userName', response);
        this.router.navigate(['']);
      },
      (error)=>{
        alert(error.error);
        this.router.navigate(['signup']);
      }
    )

    this.formData.reset();
  }
}
