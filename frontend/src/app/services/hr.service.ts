import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { EmployeeModel } from '../model/employee.model';
import { HrModel } from '../model/hr.model';

@Injectable({
  providedIn: 'root'
})
export class HrService {
  hrGet = "http://localhost:8085/api/v1/hr/get";
  hrDelete = "http://localhost:8085/api/v1/hr/delete";
  hrPost = "http://localhost:8085/api/v1/hr/save";
  hrPut = "http://localhost:8085/api/v1/hr/save";

  constructor(private http: HttpClient) { }

  addUser = (user: any) => {
    if (user.hrId == 0)
      return this.http.post(this.hrPost, user);
    else
      return this.http.put(this.hrPut, user);
  }

  getUsers = () =>
    this.http.get(this.hrGet, { observe: 'response' })
      .pipe(
        map(response => {
          const users = response.body as HrModel[];
          return { users }
        })
      )

  getById = (id: number) => this.http.get<HrModel>(this.hrGet + `/${id}`)

  delete = (id: number) => this.http.delete<any>(this.hrDelete + `/${id}`)

  update = (id: number, user: HrModel) => this.http.put(`${this.hrPut}/${id}`, user);
}
