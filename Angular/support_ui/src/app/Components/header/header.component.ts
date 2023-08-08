import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';
import { faSignOut } from '@fortawesome/free-solid-svg-icons';
import { faSignIn } from '@fortawesome/free-solid-svg-icons';
import { faUserPlus } from '@fortawesome/free-solid-svg-icons';
import { faGlobe } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  signOut = faSignOut;
  signIn = faSignIn;
  signUp = faUserPlus;
  globe = faGlobe;
  constructor(private router:Router){
  
  }
  checkAdmin(){
    return !(localStorage.getItem('userName') === "Admin");   
  }
  login(){
    return !!localStorage.getItem('userName');
  }
  onLogOut(){
    localStorage.removeItem("userName");
    this.router.navigate(["/signup"]);
  }
}
function checkAdmin() {
  throw new Error('Function not implemented.');
}

