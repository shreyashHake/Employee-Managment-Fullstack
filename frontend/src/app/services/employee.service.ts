import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { EmployeeModel } from '../model/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  employeeGet = "http://localhost:8085/api/v1/employee/get";
  employeeDelete = "http://localhost:8085/api/v1/employee/delete";
  employeePost = "http://localhost:8085/api/v1/employee/save";
  employeePut = "http://localhost:8085/api/v1/employee/save";

  constructor(private http: HttpClient) { }

  addUser = (user: any) => {
    if (user.employeeId == 0)
      return this.http.post(this.employeePost, user);
    else
      return this.http.put(this.employeePut, user);
  }

  getUsers = () =>
    this.http.get(this.employeeGet, { observe: 'response' })
      .pipe(
        map(response => {
          const users = response.body as EmployeeModel[];
          return { users }
        })
      )

  getById = (id: number) => this.http.get<EmployeeModel>(this.employeeGet + `/${id}`)

  delete = (id: number) => this.http.delete<any>(this.employeeDelete + `/${id}`)

  update = (id: number, user: EmployeeModel) => this.http.put(`${this.employeePut}/${id}`, user);

}
