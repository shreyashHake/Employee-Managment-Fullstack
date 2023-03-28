import { Component, ViewChild } from '@angular/core';
import { FormGroup, NgForm, FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { MyErrorStateMatcher } from 'src/app/model/myErrorStateMatcher';
import { HrService } from 'src/app/services/hr.service';

@Component({
  selector: 'app-manage-hr',
  templateUrl: './manage-hr.component.html',
  styleUrls: ['./manage-hr.component.scss']
})
export class ManageHrComponent {
  formGroup!:FormGroup;
  @ViewChild("userForm") usrForm!:NgForm; // it will be used for resetting the form validation messages

  get formControl(){
   return this.formGroup.controls;
  }

  errorMatcher= new MyErrorStateMatcher();

  constructor(private fb:FormBuilder,private route:ActivatedRoute,
    private hrService:HrService,private snackBar: MatSnackBar,
    private router : Router){
   }

  ngOnInit(): void {
    this.getUserById();
    this.formGroup= this.fb.group({
      hrId:[0],
      hrName:['',Validators.required],
      hrEmail:['',[Validators.required,Validators.email]],
      hrAddress:['',Validators.required],
      hrPhone:['',Validators.required],
      hrSalary:['',Validators.required]

    })
  }

  getUserById= ()=>{
    const hrId = this.route.snapshot.params['hrId'];
    if(hrId){
      this.hrService.getById(hrId).subscribe({
        next:(user=>this.formGroup.patchValue(user)),
        error:(err)=>console.log(err)
      })
    }
  }

  onPost():void{
    this.hrService.addUser(this.formGroup.value).subscribe({
      next:(data)=>{
        this.usrForm.reset();
        this.usrForm.resetForm();
        this.snackBar.open("success",'close',{
          duration:3000
        })
      },
      error: (err) => {
        this.usrForm.reset();
        this.usrForm.resetForm();
        this.snackBar.open("Modified",'close',{
          duration:3000
        })
      }
     }
     )
  }
}
