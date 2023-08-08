import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-cancel',
  templateUrl: './cancel.component.html',
  styleUrls: ['./cancel.component.css']
})
export class CancelComponent {

  constructor(private buildr: FormBuilder){

  }
  
  formData = this.buildr.group({
    reason: this.buildr.control('')
  })

  onSubmit(){
    
  }
}
