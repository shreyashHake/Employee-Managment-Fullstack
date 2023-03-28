import { Component, ViewChild } from '@angular/core';
import { FormGroup, NgForm, FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { MyErrorStateMatcher } from 'src/app/model/myErrorStateMatcher';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-update-emp',
  templateUrl: './update-emp.component.html',
  styleUrls: ['./update-emp.component.scss']
})
export class UpdateEmpComponent {
  formGroup!:FormGroup;
  action="Add";
  @ViewChild("userForm") usrForm!:NgForm; // it will be used for resetting the form validation messages

  get formControl(){
   return this.formGroup.controls;
  }

  errorMatcher= new MyErrorStateMatcher();

  constructor(private fb:FormBuilder,private route:ActivatedRoute,
    private employeeService:EmployeeService,private snackBar: MatSnackBar,
    private router : Router){
   }

  ngOnInit(): void {
    this.getUserById();
    this.formGroup= this.fb.group({
      employeeId:[0],
      employeeName:['',Validators.required],
      employeeEmail:['',[Validators.required,Validators.email]],
      employeeAddress:['',Validators.required],
      employeePhone:['',Validators.required],
      employeeSalary:['',Validators.required],
      employeeHr:['',Validators.required],

    })
  }

  getUserById= ()=>{
    const employeeId = this.route.snapshot.params['employeeId'];
    if(employeeId){
      this.action="Update";
      this.employeeService.getById(employeeId).subscribe({
        next:(user=>this.formGroup.patchValue(user)),
        error:(err)=>console.log(err)
      })
    }
  }

  onPost(): void {
    const employeeId = this.formGroup.get('employeeId')?.value;
    const user = this.formGroup.value;

    this.employeeService.update(employeeId, user).subscribe({
      next: () => {
        this.usrForm.reset();
        this.usrForm.resetForm();
        this.snackBar.open('success', 'close', {
          duration: 3000,
        });
        this.router.navigateByUrl('/empDetails');
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

}
