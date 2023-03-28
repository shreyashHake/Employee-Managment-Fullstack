import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeDetailsComponent } from './myComponents/employee-details/employee-details.component';
import { HomeComponent } from './myComponents/home/home.component';
import { HrDetailsComponent } from './myComponents/hr-details/hr-details.component';
import { ManageEmpComponent } from './myComponents/manage-emp/manage-emp.component';
import { ManageHrComponent } from './myComponents/manage-hr/manage-hr.component';
import { UpdateEmpComponent } from './myComponents/update-emp/update-emp.component';

const routes: Routes = [
  {path:'', redirectTo:'/home', pathMatch:'full'},
  {path: 'home', component: HomeComponent},
  {path: 'empDetails', component: EmployeeDetailsComponent},
  {path: 'hrDetails', component: HrDetailsComponent},
  {path: 'empManage', component: ManageEmpComponent},
  {path: 'empUpdate/:employeeId', component: UpdateEmpComponent},
  {path: 'hrManage', component: ManageHrComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
