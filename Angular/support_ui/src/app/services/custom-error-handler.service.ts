import { HttpErrorResponse } from '@angular/common/http';
import { ErrorHandler, Injectable, NgZone } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable()

export class CustomErrorHandler implements ErrorHandler{
  
  message: string = '';

  constructor(private snackbar: MatSnackBar, private zone: NgZone) { }

  handleError(error: HttpErrorResponse ){
    console.log(error.error)
    if(error.error.message === undefined){
      this.message =  `Something bad happened. Please try again later.`
    }
    else {
      this.message = error.error.message;
    }

    this.zone.run(() => {
      this.snackbar.open(
        this.message,
        'Close',
        {
          duration: 2000
        }
      );
    } )
    console.warn(`Caught by Custom Error Handler: `, error);
  }
}
