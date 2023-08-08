import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-renew',
  templateUrl: './renew.component.html',
  styleUrls: ['./renew.component.css']
})
export class RenewComponent {

  constructor(private buildr: FormBuilder){

  }
  
  formData = this.buildr.group({
    duration: this.buildr.control(''),
    paymentMode: this.buildr.control('')
  })

  onSubmit(){
    
  }
}
