import { Component } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { HrModel } from 'src/app/model/hr.model';
import { EmployeeService } from 'src/app/services/employee.service';
import { HrService } from 'src/app/services/hr.service';

@Component({
  selector: 'app-hr-details',
  templateUrl: './hr-details.component.html',
  styleUrls: ['./hr-details.component.scss']
})

export class HrDetailsComponent {
  dataSource = new MatTableDataSource<HrModel>();
  displayColumns = ['hrId', 'hrName', 'hrEmail','hrAddress','hrPhone', 'hrSalary', 'action'];


  loadUsers() {
    this.hrService.getUsers().subscribe({
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
        this.hrService.delete(id).subscribe({
          next: (resp) => {
            console.log("Employee Deleted!");
          },

        })
      }
    }
  }

  constructor(private hrService : HrService, private router: Router) { }
}
