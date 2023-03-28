import { Component } from '@angular/core';
import { EmployeeModel } from 'src/app/model/employee.model';
import { EmployeeService } from 'src/app/services/employee.service';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';


@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.scss']
})
export class EmployeeDetailsComponent {
  dataSource = new MatTableDataSource<EmployeeModel>();
  displayColumns = ['employeeId', 'employeeName', 'employeeEmail','employeeAddress','employeePhone', 'employeeSalary', 'action'];


  loadUsers() {
    this.employeeService.getUsers().subscribe({
      next: (response) => {
        this.dataSource.data = response.users;
      },
      error: (err) => console.error(err)
    })
  }

  ngOnInit(): void {
    this.loadUsers();
  }


  onBtnEdit(id: number): void {
    this.router.navigate(['/empUpdate/' + id]);
  }

  onBtnDelete(id: number): void {
    if (window.confirm('Are you sure to delete?')) {
      {
        this.employeeService.delete(id).subscribe({
          next: (resp) => {
            console.log("Employee Deleted!");
          },

        })
      }
    }
  }

  constructor(private employeeService : EmployeeService, private router: Router) { }

}
