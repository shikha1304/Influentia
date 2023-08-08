import { Component, Inject } from '@angular/core';
import { FormBuilder, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ApisService } from 'src/app/Services/apis.service';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from "@angular/material/button";

@Component({
  selector: 'app-resolution-form',
  templateUrl: './resolution-form.component.html',
  styleUrls: ['./resolution-form.component.css']
})
export class ResolutionFormComponent {
  // @ViewChild('resolve') formData: NgForm | any;
  // @Input()
  // visible!: boolean;
  // @Input()
  id!: number;

  ticketResolution= {
    resolvedByUserName: '',
    resolutionDetails: '', 
    supportTicketId: 0
  };

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,private api: ApisService, private router: Router,
      public ref: MatDialogRef<ResolutionFormComponent>, private buildr: FormBuilder
    ){
    
  }

  ngOnInit(){
    if(localStorage.getItem("userName") === null){
      alert("Login Required!!");
      this.router.navigate(["/login"]);
    }
    this.id = this.data.id;
  }

  formData = this.buildr.group({
    resolvedByUserName: this.buildr.control(''),
    resolutionDetails: this.buildr.control('')
  })
  
  onSubmit(){
    // console.log(this.formData);
    console.log("Hello");
    this.ticketResolution.resolvedByUserName = this.formData.value.resolvedByUserName!;
    this.ticketResolution.resolutionDetails = this.formData.value.resolutionDetails!;
    this.ticketResolution.supportTicketId = this.id;

    // con?sole.log("Hello");
    console.log(this.ticketResolution);

    if(!this.ticketResolution.resolvedByUserName || !this.ticketResolution.resolutionDetails){
      window.alert("Please fill all the required fields");
      return;
    }

    this.api.closeticket(this.ticketResolution).subscribe((response)=>{
      alert("Resolution Successful");
    })
    this.ref.close();
  }

}
